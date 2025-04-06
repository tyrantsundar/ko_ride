package com.ko_ride.notification.strategy;

import com.ko_ride.notification.event.RideRequestedEvent;

public class DriverFilterStrategyFactory {

    public static DriverFilterStrategy getDriverFilterStrategy(DriverFilterStrategyEnum driverFilterStrategyEnum){
        switch (driverFilterStrategyEnum){
            case ALL -> {
                return new AllDriverStrategy();
            }
            case NEAREST -> {
                return new NearestDriverStrategy();
            }
            default -> {
                throw new RuntimeException("Unhandled DriverFilterStrategyEnum in factory");
            }
        }
    }
}
