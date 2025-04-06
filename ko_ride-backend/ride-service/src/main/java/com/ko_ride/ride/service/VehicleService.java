package com.ko_ride.ride.service;

import com.ko_ride.ride.dto.VehicleDTO;
import com.ko_ride.ride.entity.Vehicle;

import java.util.Optional;

public interface VehicleService {
    VehicleDTO registerVehicle(VehicleDTO vehicleDTO);
    Optional<VehicleDTO> getVehicleById(Long vehicleId);
}


