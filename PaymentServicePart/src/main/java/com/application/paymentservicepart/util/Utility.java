package com.application.paymentservicepart.util;

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
}
