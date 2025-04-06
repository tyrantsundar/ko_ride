package com.ko_ride.ride.util;

import com.ko_ride.ride.entity.Ride;
import com.ko_ride.ride.event.RideRequestedEvent;

public class EventUtil {

    public static RideRequestedEvent createRideRequestedEvent(Ride ride){
        RideRequestedEvent.Location startLocation = new RideRequestedEvent.Location(ride.getStartLocation().getLongitude(), ride.getStartLocation().getLatitude());
        RideRequestedEvent.Location targetLocation = new RideRequestedEvent.Location(ride.getTargetLocation().getLongitude(), ride.getTargetLocation().getLatitude());

        RideRequestedEvent event = new RideRequestedEvent(
                ride.getRideId(),
                ride.getUser().getUserId(),
                startLocation,
                targetLocation
        );
        return event;
    }
}
