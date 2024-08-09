package com.application.orderservicepart.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Utility {
    public static final String  newOrderTopic = "new-orders";
    public static final String reverseOrderTopic = "reverse-orders";
    public static final String newPaymentTopic = "new-payments";
    public static final String reversePaymentTopic = "reverse-payments";
    public static final String newStockTopic = "new-stocks";
    public static final String reverseStockTopic = "reverse-stocks";
    public static final String newNotificationTopic = "new-notifications";

    public static final String productConsumerGrpId = "product-consumer-grp";
    public static final String orderConsumerGrpId = "order-consumer-grp";
    public static final String paymentConsumerGrpId = "payment-consumer-grp";
    public static final String stockConsumerGrpId = "stock-consumer-grp";
    public static final String notificationConsumerGrpId = "notification-consumer-grp";

    public static Object getObjectFromJson(String json, Class className) {
        Gson gson = new Gson();
        try {
            Object object = gson.fromJson(json, className);
            return object;
        } catch (JsonSyntaxException e) {
            log.error(e.getMessage());
            return new Object();
        }
    }
}
