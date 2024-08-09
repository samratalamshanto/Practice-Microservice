package com.application.orderservicepart.service;

import com.application.orderservicepart.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public boolean processOrder(Product product) {
        return true;
    }
}
