package com.application.orderservicepart.service;

import com.application.orderservicepart.dto.Product;
import com.application.orderservicepart.entity.OrderDetails;
import com.application.orderservicepart.util.Utility;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaListenerService {
    private final OrderService orderService;

//    @KafkaListener(topics = Utility.orderServiceCreateTopic, groupId = Utility.orderConsumerGrpId)
//    public void consumeCreateOrderTopics(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) {
//
//        String entityString = record.value();
//        Gson gson = new Gson();
//        Product product = gson.fromJson(entityString, Product.class);
//        boolean opValue;
//
//        opValue = orderService.processOrder(product);
//
//        if (opValue) {
//            acknowledgment.acknowledge();
//        }
//
//        long offset = record.offset();
//        int partition = record.partition();
//        String topic = record.topic();
//
//        log.info(String.format("HW:  offset -> %d, partition -> %d, topic -> %s, message -> %s", offset, partition, topic, product.toString()));
//    }


    @KafkaListener(topics = Utility.orderServiceCreateTopic, groupId = Utility.orderConsumerGrpId)
    public void consumeCreateOrderTopics(ConsumerRecord<String, String> record) {

        String entityString = record.value();
        Product product = (Product) Utility.getObjectFromJson(entityString, Product.class);
        boolean opValue = orderService.processOrder(product);

        long offset = record.offset();
        int partition = record.partition();
        String topic = record.topic();

        log.info(String.format("HW:  offset -> %d, partition -> %d, topic -> %s, message -> %s", offset, partition, topic, product.toString()));
    }

    @KafkaListener(topics = Utility.orderServiceRollbackTopic, groupId = Utility.orderConsumerGrpId)
    public void consumeOrderRollbackTopic(ConsumerRecord<String, OrderDetails> record, Acknowledgment acknowledgment) {

        OrderDetails entity = record.value();
        int opValue = 0;

        //   opValue = orderService.add(entity);

        if (opValue != 0) {
            acknowledgment.acknowledge();
        }

        long offset = record.offset();
        int partition = record.partition();
        String topic = record.topic();

        log.info(String.format("HW:  offset -> %d, partition -> %d, topic -> %s, message -> %s", offset, partition, topic, entity.toString()));
    }


}
