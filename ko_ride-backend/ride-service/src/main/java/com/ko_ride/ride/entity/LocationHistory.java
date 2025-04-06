package com.ko_ride.ride.entity;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "location_history")
public class LocationHistory {
    @Id
    private String id;

    private Long rideId;
    private Long vehicleId;

    private List<Location> locationPoints = new ArrayList<>();
}
