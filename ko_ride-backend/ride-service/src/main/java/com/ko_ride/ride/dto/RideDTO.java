package com.ko_ride.ride.dto;

import java.time.LocalDateTime;

public class RideDTO {

    private Long rideId;
    private Long driverId;
    private Long userId;
    private Long vehicleId;

    private LocationDTO startLocation;
    private LocationDTO targetLocation;

    private String status;
    private Double distance;
    private Double cost;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public RideDTO() {
    }

    public RideDTO(Long rideId, Long driverId, Long userId, Long vehicleId, LocationDTO startLocation, LocationDTO targetLocation, String status, Double distance, Double cost, LocalDateTime startTime, LocalDateTime endTime) {
        this.rideId = rideId;
        this.driverId = driverId;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.startLocation = startLocation;
        this.targetLocation = targetLocation;
        this.status = status;
        this.distance = distance;
        this.cost = cost;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocationDTO getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(LocationDTO startLocation) {
        this.startLocation = startLocation;
    }

    public LocationDTO getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(LocationDTO targetLocation) {
        this.targetLocation = targetLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

}
