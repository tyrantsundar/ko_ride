package com.ko_ride.payment.repository;


import com.ko_ride.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByRideIdAndUserId(Long rideId, Long userId);
}
