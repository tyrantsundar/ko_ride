package com.ko_ride.ride.dto;

public class NearbyDriversResponse {
    private Long driverId;
    private double distanceInKm;
    private double etaInMinutes;

    public NearbyDriversResponse(Long driverId, double distanceInKm, double etaInMinutes) {
        this.driverId = driverId;
        this.distanceInKm = distanceInKm;
        this.etaInMinutes = etaInMinutes;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public double getEtaInMinutes() {
        return etaInMinutes;
    }

    public void setEtaInMinutes(double etaInMinutes) {
        this.etaInMinutes = etaInMinutes;
    }
}
