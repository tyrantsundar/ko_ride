package com.ko_ride.payment.service.impl;

import com.ko_ride.payment.dto.InitiatePaymentRequestDto;
import com.ko_ride.payment.dto.PaymentMethodDto;
import com.ko_ride.payment.dto.PaymentResponseDto;
import com.ko_ride.payment.entity.Payment;
import com.ko_ride.payment.entity.PaymentMethod;
import com.ko_ride.payment.entity.PaymentStatus;
import com.ko_ride.payment.mapper.PaymentMapper;
import com.ko_ride.payment.repository.PaymentMethodRepository;
import com.ko_ride.payment.repository.PaymentRepository;
import com.ko_ride.payment.service.PaymentService;
import com.ko_ride.payment.strategy.PaymentProcessingStrategy;
import com.ko_ride.payment.strategy.PaymentProcessingStrategyFactory;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentMapper paymentMapper;
    private final PaymentProcessingStrategyFactory paymentProcessingStrategyFactory;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMethodRepository paymentMethodRepository, PaymentMapper paymentMapper, PaymentProcessingStrategyFactory paymentProcessingStrategyFactory) {
        this.paymentRepository = paymentRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.paymentMapper = paymentMapper;
        this.paymentProcessingStrategyFactory = paymentProcessingStrategyFactory;
    }

    @Override
    @Transactional
    public PaymentResponseDto initiatePayment(InitiatePaymentRequestDto requestDto) {

        double dividedSum = requestDto.getMethods().stream().mapToDouble(PaymentMethodDto::getAmount).sum();
        if(dividedSum != requestDto.getTotalAmount()){
            throw new RuntimeException("Failed to process payment method: not paying full payment");
        }
        Payment payment = paymentMapper.toPaymentEntity(requestDto);
//        payment = paymentRepository.save(payment);
//        List<PaymentMethod> savedPaymentMethods = new ArrayList<>();
//        for(PaymentMethod paymentMethod : payment.getPaymentMethods()){
//            paymentMethod.setPayment(payment);
//            PaymentMethod savedPaymentMethod = paymentMethodRepository.save(paymentMethod);
//            savedPaymentMethods.add(savedPaymentMethod);
//        }
//        payment.setPaymentMethods(savedPaymentMethods);

        List<PaymentMethod> paymentMethodList = new ArrayList<>();
        for(PaymentMethodDto paymentMethodDto : requestDto.getMethods()){
            PaymentMethod paymentMethod = paymentMapper.toPaymentMethod(paymentMethodDto);
            PaymentProcessingStrategy paymentStrategy = paymentProcessingStrategyFactory.getPaymentStrategy(paymentMethodDto);
            try {
                String referenceId = paymentStrategy.process(payment.getId(), paymentMethodDto);
                paymentMethod.setRefernceId(referenceId);
                paymentMethod.setStatus(PaymentStatus.SUCCESS);
                paymentMethod.setPayment(payment);
            } catch (Exception e) {
                throw new RuntimeException("Failed to process payment method: " + paymentMethodDto.getMethod(), e);
            }
            paymentMethod = paymentMethodRepository.save(paymentMethod);
            paymentMethodList.add(paymentMethod);
        }
        payment.setPaymentMethods(paymentMethodList);
        payment.setStatus(PaymentStatus.SUCCESS);
        payment = paymentRepository.save(payment);
        return paymentMapper.toPaymentResponseDto(payment);
    }

    @Override
    public PaymentResponseDto getPaymentStatus(Long tripId, Long userId) {
        Payment payment = paymentRepository.findByRideIdAndUserId(tripId, userId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return paymentMapper.toPaymentResponseDto(payment);
    }

}
