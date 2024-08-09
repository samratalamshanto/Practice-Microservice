package com.application.productservicepart.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class Utility {
    public static final String orderServiceCreateTopic = "OrderServiceCreate";
    public static final String orderServiceRollbackTopic = "OrderServiceRollback";
    public static final String productServiceCreateTopic = "ProductServiceCreate";
    public static final String productServiceRollbackTopic = "ProductServiceRollback";
    public static final String paymentServiceCreateTopic = "PaymentServiceCreate";

    public static final String productConsumerGrpId = "ProductConsumerGrpId";
    public static final String orderConsumerGrpId = "OrderConsumerGrpId";
    public static final String paymentConsumerGrpId = "PaymentConsumerGrpId";


    public static String getJsonString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
