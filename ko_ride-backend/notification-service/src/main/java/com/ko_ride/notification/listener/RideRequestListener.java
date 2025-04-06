package com.ko_ride.notification.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ko_ride.notification.event.RideRequestedEvent;
import com.ko_ride.notification.service.RideRequestedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RideRequestListener {

    private final ObjectMapper objectMapper;

    private final RideRequestedService rideRequestedService;

    public RideRequestListener(ObjectMapper objectMapper, RideRequestedService rideRequestedService) {
        this.objectMapper = objectMapper;
        this.rideRequestedService = rideRequestedService;
    }

    @KafkaListener(topics = "${event.notification.topics.trip-request}", groupId = "notification-group")
    public void handleRideRequested(String message) throws JsonProcessingException {
        try {
            log.info("RideRequestListener -> Message received {} ",message);
            RideRequestedEvent event = objectMapper.readValue(message, RideRequestedEvent.class);
            rideRequestedService.notifyDrivers(event);
            log.info("RideRequestListener -> Message response SUCCESS {}",message);
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
