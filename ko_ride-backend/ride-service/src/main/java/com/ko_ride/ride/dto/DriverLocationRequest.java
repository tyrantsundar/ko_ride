package com.ko_ride.ride.dto;

public class DriverLocationRequest {
    private Long driverId;
    private double lat;
    private double lon;

    public DriverLocationRequest() {
    }

    public DriverLocationRequest(Long driverId, double lat, double lon) {
        this.driverId = driverId;
        this.lat = lat;
        this.lon = lon;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
