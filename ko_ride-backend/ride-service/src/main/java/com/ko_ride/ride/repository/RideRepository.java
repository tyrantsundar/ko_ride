package com.ko_ride.ride.repository;

import com.ko_ride.ride.entity.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByUser_userId(Long userId);
    List<Ride> findByDriver_driverId(Long driverId);
}

