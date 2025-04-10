package com.ko_ride.payment.entity;

import jakarta.persistence.Enumerated;

public enum PaymentStatus {
    PENDING,
    PROCESSING,
    SUCCESS,
    FAILED,
    CANCELLED
}
