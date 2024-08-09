package com.application.orderservicepart.config.kafka;

import com.application.orderservicepart.util.Utility;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic createOrderTopic() {
        return TopicBuilder
                .name(Utility.newOrderTopic)
                .build();
    }

    @Bean
    public NewTopic rollbackOrderTopic() {
        return TopicBuilder
                .name(Utility.reverseOrderTopic)
                .build();
    }

    @Bean
    public NewTopic createPaymentTopic() {
        return TopicBuilder
                .name(Utility.newPaymentTopic)
                .build();
    }

    @Bean
    public NewTopic rollbackPaymentTopic() {
        return TopicBuilder
                .name(Utility.reversePaymentTopic)
                .build();
    }

    @Bean
    public NewTopic createStockTopic() {
        return TopicBuilder
                .name(Utility.newStockTopic)
                .build();
    }

    @Bean
    public NewTopic rollbackStockTopic() {
        return TopicBuilder
                .name(Utility.reverseStockTopic)
                .build();
    }

    @Bean
    public NewTopic createNotificationTopic() {
        return TopicBuilder
                .name(Utility.newNotificationTopic)
                .build();
    }


}
