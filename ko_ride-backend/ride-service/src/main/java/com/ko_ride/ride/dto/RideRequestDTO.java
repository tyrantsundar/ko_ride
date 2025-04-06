package com.ko_ride.ride.dto;

public class RideRequestDTO {
    private Long userId;
    private String startLocation;
    private String targetLocation;

    public RideRequestDTO() {
    }

    public RideRequestDTO(Long userId, String startLocation, String targetLocation) {
        this.userId = userId;
        this.startLocation = startLocation;
        this.targetLocation = targetLocation;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(String targetLocation) {
        this.targetLocation = targetLocation;
    }
}
