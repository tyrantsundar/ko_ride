package com.ko_ride.ride.dto;

import java.time.LocalDateTime;

public class PaymentDTO {
    private Long paymentId;
    private Long rideId;
    private Long userId;
    private Long driverId;
    private Double amount;
    private String paymentStatus; // PENDING, SUCCESS, FAILED
    private LocalDateTime paymentTime;

    public PaymentDTO() {
    }

    public PaymentDTO(Long paymentId, Long rideId, Long userId, Long driverId, Double amount, String paymentStatus, LocalDateTime paymentTime) {
        this.paymentId = paymentId;
        this.rideId = rideId;
        this.userId = userId;
        this.driverId = driverId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
        this.paymentTime = paymentTime;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalDateTime paymentTime) {
        this.paymentTime = paymentTime;
    }
}
