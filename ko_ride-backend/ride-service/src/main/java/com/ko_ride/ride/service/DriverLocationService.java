package com.ko_ride.ride.service;

import com.ko_ride.ride.dto.DriverLocationRequest;
import com.ko_ride.ride.dto.NearbyDriversRequest;
import com.ko_ride.ride.dto.NearbyDriversResponse;

import java.util.List;

public interface DriverLocationService {
    public boolean registerDriverLocation(DriverLocationRequest request);
    public List<NearbyDriversResponse> getNearbyDrivers(NearbyDriversRequest request);
}
