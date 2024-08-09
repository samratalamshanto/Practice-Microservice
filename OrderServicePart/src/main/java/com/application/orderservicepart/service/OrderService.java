package com.application.orderservicepart.service;

import com.application.orderservicepart.dto.Product;
import com.application.orderservicepart.entity.OrderDetails;
import com.application.orderservicepart.enums.CommonStatus;
import com.application.orderservicepart.reposiroty.order.OrderRepo;
import com.application.orderservicepart.util.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final KafkaTemplate<String, OrderDetails> kafkaTemplate;
    private final OrderRepo orderRepo;

    public boolean processOrder(Product product) {
        OrderDetails order = new OrderDetails();
        order.setProductId(product.getId());
        order.setProductName(product.getName());
        order.setProductPrice(product.getPrice());
        order.setProductDescription(product.getDescription());
        order.setStatus(CommonStatus.Created);
        try {
            order = orderRepo.save(order);
            kafkaTemplate.send(Utility.newOrderTopic, order);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
