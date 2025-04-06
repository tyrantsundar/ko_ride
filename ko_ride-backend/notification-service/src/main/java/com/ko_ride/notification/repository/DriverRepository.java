package com.ko_ride.notification.repository;


import com.ko_ride.notification.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> findByMail(String mail);
}
