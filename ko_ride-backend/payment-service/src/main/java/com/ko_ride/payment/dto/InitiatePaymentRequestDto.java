package com.ko_ride.payment.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class InitiatePaymentRequestDto {
    private Long userId;
    private Long rideId;
    private double totalAmount;
    private List<PaymentMethodDto> methods;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<PaymentMethodDto> getMethods() {
        return methods;
    }

    public void setMethods(List<PaymentMethodDto> methods) {
        this.methods = methods;
    }
}
