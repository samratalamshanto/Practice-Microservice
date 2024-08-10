package com.application.orderservicepart.service;

import com.application.orderservicepart.dto.order.OrderDto;
import com.application.orderservicepart.entity.OrderDetails;
import com.application.orderservicepart.enums.CommonStatus;
import com.application.orderservicepart.reposiroty.order.OrderRepo;
import com.application.orderservicepart.util.Utility;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final KafkaTemplate<String, OrderDetails> kafkaTemplate;
    private final OrderRepo orderRepo;
    ModelMapper modelMapper = new ModelMapper();

    public boolean processOrder(OrderDto orderDto) {
        OrderDetails order = new OrderDetails();
        modelMapper.map(orderDto, order);
        order.setStatus(CommonStatus.Created);
        order.setId(null);
        order.setCreatedDT(LocalDateTime.now());
        try {
            order = orderRepo.save(order);
            orderDto.setOrderId(order.getId());
            kafkaTemplate.send(Utility.newPaymentTopic, order);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
