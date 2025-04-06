package com.ko_ride.ride.service;

import com.ko_ride.ride.dto.PaymentDTO;

import java.util.Optional;

public interface PaymentService {
    PaymentDTO processPayment(PaymentDTO paymentDTO);
    Optional<PaymentDTO> getPaymentByRideId(Long rideId);
}

