package com.ko_ride.ride.service.impl;

import com.ko_ride.ride.dto.PaymentDTO;
import com.ko_ride.ride.entity.Payment;
import com.ko_ride.ride.mapper.PaymentMapper;
import com.ko_ride.ride.repository.PaymentRepository;
import com.ko_ride.ride.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentDTO processPayment(PaymentDTO paymentDTO) {
        Payment payment = paymentMapper.toEntity(paymentDTO);
        Payment savedPayment = paymentRepository.save(payment);
        return paymentMapper.toDTO(savedPayment);
    }

    @Override
    public Optional<PaymentDTO> getPaymentByRideId(Long rideId) {
        return paymentRepository.findByRide_RideId(rideId).map(paymentMapper::toDTO);
    }
}


