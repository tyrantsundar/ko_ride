package com.ko_ride.ride.service;

import com.ko_ride.ride.dto.LocationHistoryDTO;
import com.ko_ride.ride.entity.LocationHistory;

import java.util.List;

public interface LocationHistoryService {
    LocationHistoryDTO saveLocation(LocationHistoryDTO locationHistoryDTO);
    List<LocationHistoryDTO> getLocationHistoryByRideId(Long rideId);
}

