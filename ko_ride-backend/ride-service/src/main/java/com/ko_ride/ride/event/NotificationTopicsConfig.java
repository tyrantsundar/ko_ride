package com.ko_ride.ride.event;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "event.notification.topics")
public class NotificationTopicsConfig {

    private String tripRequest;
    private String rideAccepted;
    private String rideCompleted;
    private String paymentInitiated;

    // Getters and Setters

    public String getTripRequest() {
        return tripRequest;
    }

    public void setTripRequest(String tripRequest) {
        this.tripRequest = tripRequest;
    }

    public String getRideAccepted() {
        return rideAccepted;
    }

    public void setRideAccepted(String rideAccepted) {
        this.rideAccepted = rideAccepted;
    }

    public String getRideCompleted() {
        return rideCompleted;
    }

    public void setRideCompleted(String rideCompleted) {
        this.rideCompleted = rideCompleted;
    }

    public String getPaymentInitiated() {
        return paymentInitiated;
    }

    public void setPaymentInitiated(String paymentInitiated) {
        this.paymentInitiated = paymentInitiated;
    }
}
