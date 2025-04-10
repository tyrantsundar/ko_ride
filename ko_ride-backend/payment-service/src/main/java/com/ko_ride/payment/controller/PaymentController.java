package com.ko_ride.payment.controller;

import com.ko_ride.payment.dto.InitiatePaymentRequestDto;
import com.ko_ride.payment.dto.PaymentResponseDto;
import com.ko_ride.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate")
    public ResponseEntity<PaymentResponseDto> initiatePayment(@RequestBody InitiatePaymentRequestDto requestDto) {
        PaymentResponseDto responseDto = paymentService.initiatePayment(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/status")
    public ResponseEntity<PaymentResponseDto> getPaymentStatus(
            @RequestParam Long userId,
            @RequestParam Long tripId
    ) {
        PaymentResponseDto responseDto = paymentService.getPaymentStatus(tripId, userId);
        return ResponseEntity.ok(responseDto);
    }

}
