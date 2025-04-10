package com.ko_ride.payment.strategy;

import com.ko_ride.payment.dto.PaymentMethodDto;
import com.ko_ride.payment.entity.PaymentMethodType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class WalletPaymentProcessor implements PaymentProcessingStrategy{
    @Override
    public String process(Long paymentId, PaymentMethodDto paymentMethodDto) {
//        log.info("PaymentId {} paid amount {} via wallet payment processor.",paymentId,paymentMethodDto.getAmount());
        return UUID.randomUUID().toString();
    }

    @Override
    public PaymentMethodType getMethod(){
        return PaymentMethodType.WALLET;
    }
}
