package com.ko_ride.notification.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Location {
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
