package com.ko_ride.ride.dto;

public class VehicleDTO {
    private Long vehicleId;
    private String vehicleNumber;
    private Long driverId;
    private String type; // SEDAN, SUV, HATCHBACK, etc.

    public VehicleDTO() {
    }

    public VehicleDTO(Long vehicleId, String vehicleNumber, Long driverId, String type) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.driverId = driverId;
        this.type = type;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
