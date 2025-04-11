package com.ko_ride.ride.dto;

public class NearbyDriversResponse {
    private String driverId;
    private double distanceInKm;

    public NearbyDriversResponse(String driverId, double distanceInKm) {
        this.driverId = driverId;
        this.distanceInKm = distanceInKm;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }
}
