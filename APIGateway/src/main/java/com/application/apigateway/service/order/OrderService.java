package com.application.apigateway.service.order;

import com.application.apigateway.payload.request.order.OrderDto;
import com.application.apigateway.payload.response.CommonResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    ResponseEntity<CommonResponse> createOrder(OrderDto orderDto, HttpServletRequest request);
}
