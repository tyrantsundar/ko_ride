package com.ko_ride.notification.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RideRequestedEvent {
    private Long rideId;
    private Long userId;
    private Location startLocation;
    private Location targetLocation;

    public RideRequestedEvent() {
    }

    public RideRequestedEvent(Long rideId, Long userId, Location startLocation, Location targetLocation) {
        this.rideId = rideId;
        this.userId = userId;
        this.startLocation = startLocation;
        this.targetLocation = targetLocation;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(Location targetLocation) {
        this.targetLocation = targetLocation;
    }

   public static  class Location {
        private Double latitude;
        private Double longitude;

        public Location() {
        }

        public Location(Double longitude, Double latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }
    }

}
