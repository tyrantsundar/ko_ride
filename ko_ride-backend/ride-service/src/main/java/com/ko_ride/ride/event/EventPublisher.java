package com.ko_ride.ride.event;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public EventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Transactional
    public boolean publishEvent(String topic, String message){
        kafkaTemplate.send(topic, message);
        return true;
    }
}
