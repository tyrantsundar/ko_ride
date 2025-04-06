package com.ko_ride.ride.controller;

import com.ko_ride.ride.dto.PaymentDTO;
import com.ko_ride.ride.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/process")
    public ResponseEntity<PaymentDTO> processPayment(@RequestBody PaymentDTO paymentDTO) {
        return ResponseEntity.ok(paymentService.processPayment(paymentDTO));
    }

    @GetMapping("/ride/{rideId}")
    public ResponseEntity<PaymentDTO> getPaymentByRideId(@PathVariable Long rideId) {
        return paymentService.getPaymentByRideId(rideId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
