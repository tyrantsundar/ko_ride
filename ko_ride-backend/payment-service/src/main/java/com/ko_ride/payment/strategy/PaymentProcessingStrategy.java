package com.ko_ride.payment.strategy;

import com.ko_ride.payment.dto.PaymentMethodDto;
import com.ko_ride.payment.entity.PaymentMethod;
import com.ko_ride.payment.entity.PaymentMethodType;

public interface PaymentProcessingStrategy {
    public String process(Long paymentId, PaymentMethodDto paymentMethodDto);
    public PaymentMethodType getMethod();
}
