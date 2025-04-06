package com.ko_ride.ride.repository;

import com.ko_ride.ride.entity.LocationHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LocationHistoryRepository extends MongoRepository<LocationHistory, String> {
    List<LocationHistory> findByRideId(Long rideId);
}

