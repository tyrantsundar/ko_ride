package com.ko_ride.payment.service;


import com.ko_ride.payment.dto.InitiatePaymentRequestDto;
import com.ko_ride.payment.dto.PaymentResponseDto;

import java.util.List;

public interface PaymentService {
    PaymentResponseDto initiatePayment(InitiatePaymentRequestDto requestDto);
    PaymentResponseDto getPaymentStatus(Long tripId, Long userId);
}
