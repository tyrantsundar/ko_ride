package com.ko_ride.ride.service;

import com.ko_ride.ride.dto.DriverDTO;
import com.ko_ride.ride.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    DriverDTO registerDriver(DriverDTO driverDTO);
    Optional<DriverDTO> getDriverById(Long driverId);
    List<DriverDTO> getAllDrivers();
}


