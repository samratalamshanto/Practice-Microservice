package com.application.apigateway.service.order;

import com.application.apigateway.config.security.jwt.JwtUtilsService;
import com.application.apigateway.entities.user.User;
import com.application.apigateway.enums.CommonStatus;
import com.application.apigateway.payload.request.order.OrderDto;
import com.application.apigateway.payload.response.CommonResponse;
import com.application.apigateway.util.Utility;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final KafkaTemplate<String, OrderDto> kafkaTemplate;
    private final JwtUtilsService jwtUtilsService;

    @Override
    public ResponseEntity<CommonResponse> createOrder(OrderDto orderDto, HttpServletRequest request) {
        CommonResponse commonResponse = new CommonResponse(400, false, "Failed to create order.", null);
        try {
            if (orderDto.getProductPrice() > 0) {
                orderDto.setStatus(CommonStatus.Created);
                User createdUser = jwtUtilsService.getUserFromToken(request);
                orderDto.setCreatedBy(createdUser.getId());
                orderDto.setCreatedByUsername(createdUser.getUsername());
                kafkaTemplate.send(Utility.newOrderTopic, orderDto);
                commonResponse = new CommonResponse(200, true, "Order created successfully", null);
                return ResponseEntity.ok(commonResponse);
            } else {
                commonResponse.setMessage("Product price is less than or equal to 0");
                return ResponseEntity.badRequest().body(commonResponse);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error("Error while creating order", e);
            throw new RuntimeException(e);
        }
    }
}
