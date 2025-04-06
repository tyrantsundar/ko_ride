package com.ko_ride.notification.strategy;

import com.ko_ride.notification.entity.Driver;
import com.ko_ride.notification.event.RideRequestedEvent;
import com.ko_ride.notification.repository.DriverRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllDriverStrategy  implements  DriverFilterStrategy {

    @Override
    public List<Driver> getDrivers(RideRequestedEvent rideRequestedEvent, List<Driver> drivers) {
        return drivers;
    }
}
