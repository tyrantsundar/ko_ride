package com.ko_ride.payment.mapper;

import com.ko_ride.payment.dto.InitiatePaymentRequestDto;
import com.ko_ride.payment.dto.PaymentMethodDto;
import com.ko_ride.payment.dto.PaymentResponseDto;
import com.ko_ride.payment.entity.Payment;
import com.ko_ride.payment.entity.PaymentMethod;
import com.ko_ride.payment.entity.PaymentStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentMapper {

    public Payment toPaymentEntity(InitiatePaymentRequestDto dto){
        Payment payment = new Payment();
        payment.setUserId(dto.getUserId());
        payment.setRideId(dto.getRideId());
        payment.setTotalAmount(dto.getTotalAmount());
        payment.setPaymentMethods(toPaymentMethodList(dto.getMethods()));
        payment.setStatus(PaymentStatus.PENDING);
        payment.setCreatedAt(LocalDateTime.now());
        payment.setModifiedAt(LocalDateTime.now());
        return payment;
    }

    public List<PaymentMethod> toPaymentMethodList(List<PaymentMethodDto> paymentMethodDtos){
        List<PaymentMethod> paymentMethodList = new ArrayList<>();
        for(PaymentMethodDto paymentMethodDto : paymentMethodDtos){
            paymentMethodList.add(toPaymentMethod(paymentMethodDto));
        }
        return paymentMethodList;
    }

    public List<PaymentMethodDto> toPaymentMethodDtoList(List<PaymentMethod> paymentMethods){
        List<PaymentMethodDto> paymentMethodList = new ArrayList<>();
        for(PaymentMethod paymentMethod : paymentMethods){
            paymentMethodList.add(toPaymentMethodDto(paymentMethod));
        }
        return paymentMethodList;
    }

    public PaymentResponseDto toPaymentResponseDto(Payment payment){
        PaymentResponseDto responseDto = new PaymentResponseDto();
        responseDto.setUserId(payment.getUserId());
        responseDto.setRideId(payment.getRideId());
        responseDto.setTotalAmount(payment.getTotalAmount());
        responseDto.setStatus(payment.getStatus());
        responseDto.setCreatedAt(payment.getCreatedAt());
        responseDto.setUpdatedAt(payment.getModifiedAt());
        responseDto.setPaymentId(payment.getId());
        responseDto.setMethods(toPaymentMethodDtoList(payment.getPaymentMethods()));
        return responseDto;
    }


    public Payment toPayment(PaymentResponseDto dto){
        Payment payment = new Payment();
        payment.setUserId(dto.getUserId());
        payment.setRideId(dto.getRideId());
        payment.setTotalAmount(dto.getTotalAmount());
        payment.setStatus(dto.getStatus());
        payment.setCreatedAt(dto.getCreatedAt());
        payment.setModifiedAt(dto.getUpdatedAt());
        payment.setId(dto.getPaymentId());
        payment.setPaymentMethods(toPaymentMethodList(dto.getMethods()));
        return payment;
    }

    public PaymentMethodDto toPaymentMethodDto(PaymentMethod paymentMethod){
        PaymentMethodDto paymentMethodDto = new PaymentMethodDto();
        paymentMethodDto.setMethod(paymentMethod.getMethod());
        paymentMethodDto.setReferenceId(paymentMethod.getRefernceId());
        paymentMethodDto.setAmount(paymentMethod.getAmount());
        paymentMethodDto.setUpdatedAt(paymentMethod.getModifiedAt());
        return paymentMethodDto;
    }

    public PaymentMethod toPaymentMethod(PaymentMethodDto paymentMethodDto){
        PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setStatus(PaymentStatus.PENDING);
        paymentMethod.setCreatedAt(LocalDateTime.now());
        paymentMethod.setModifiedAt(LocalDateTime.now());
        paymentMethod.setMethod(paymentMethodDto.getMethod());
        paymentMethod.setRefernceId(paymentMethodDto.getReferenceId());
        paymentMethod.setAmount(paymentMethodDto.getAmount());
        paymentMethod.setModifiedAt(paymentMethodDto.getUpdatedAt());
        return paymentMethod;
    }
}
