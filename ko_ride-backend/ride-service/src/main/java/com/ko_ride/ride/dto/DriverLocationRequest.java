package com.ko_ride.ride.dto;

public class DriverLocationRequest {
    private String driverId;
    private double lat;
    private double lon;

    public DriverLocationRequest() {
    }

    public DriverLocationRequest(String driverId, double lat, double lon) {
        this.driverId = driverId;
        this.lat = lat;
        this.lon = lon;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
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
