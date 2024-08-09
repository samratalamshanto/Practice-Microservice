package com.application.productservicepart.service;

import com.application.productservicepart.entity.Product;
import com.application.productservicepart.util.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public boolean addProduct(Product product) {
        try {
            kafkaTemplate.send(Utility.orderServiceCreateTopic, Utility.getJsonString(product));
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
