package com.ko_ride.ride.dto;

public class NearbyDriversRequest {
    private double lat;
    private double lon;
    private double radiusInKm;

    public NearbyDriversRequest(double lat, double lon, double radiusInKm) {
        this.lat = lat;
        this.lon = lon;
        this.radiusInKm = radiusInKm;
    }

    public NearbyDriversRequest() {
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

    public double getRadiusInKm() {
        return radiusInKm;
    }

    public void setRadiusInKm(double radiusInKm) {
        this.radiusInKm = radiusInKm;
    }
}
