package com.ko_ride.ride.mapper;

import com.ko_ride.ride.dto.PaymentDTO;
import com.ko_ride.ride.entity.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO toDTO(Payment payment);
    Payment toEntity(PaymentDTO paymentDTO);
}

