package com.ko_ride.ride.quad;

public class Point {
    private double lat; // latitude
    private double lon; // longitude
    private String driverId;

    public Point(double lat, double lon, String driverId) {
        this.lat = lat;
        this.lon = lon;
        this.driverId = driverId;
    }

    public Point() {
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

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

}
