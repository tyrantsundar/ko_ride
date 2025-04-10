package com.ko_ride.payment.strategy;

import com.ko_ride.payment.dto.PaymentMethodDto;
import com.ko_ride.payment.entity.PaymentMethodType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class PaymentProcessingStrategyFactory {

    private final Map<PaymentMethodType, PaymentProcessingStrategy> strategyMap = new EnumMap<>(PaymentMethodType.class);


    public PaymentProcessingStrategyFactory(List<PaymentProcessingStrategy> strategyList) {
        for(PaymentProcessingStrategy strategy : strategyList){
            strategyMap.put(strategy.getMethod(), strategy);
        }
    }

    public PaymentProcessingStrategy getPaymentStrategy(PaymentMethodDto paymentMethodDto){
        PaymentProcessingStrategy strategy = strategyMap.get(paymentMethodDto.getMethod());
        if (strategy == null) {
            throw new IllegalArgumentException("No payment strategy found for method: " + paymentMethodDto.getMethod());
        }
        return strategy;
    }
}
