package com.ko_ride.notification.strategy;

import com.ko_ride.notification.entity.Driver;
import com.ko_ride.notification.event.RideRequestedEvent;

import java.util.List;

public interface DriverFilterStrategy {
    List<Driver> getDrivers(RideRequestedEvent rideRequestedEvent, List<Driver> drivers);
}
