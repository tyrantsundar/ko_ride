package com.ko_ride.ride.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ko_ride.ride.dto.RideDTO;
import com.ko_ride.ride.entity.Ride;

import java.util.List;
import java.util.Optional;

public interface RideService {
    RideDTO requestRide(RideDTO rideDTO) throws JsonProcessingException;
    boolean acceptRide(Long rideId, Long driverId);
    Optional<RideDTO> getRideById(Long rideId);
    List<RideDTO> getUserRideHistory(Long userId);
    List<RideDTO> getDriverRideHistory(Long driverId);
}

