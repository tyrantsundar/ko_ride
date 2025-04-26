package com.ko_ride.ride.dto;

public class DriverDTO {

    private Long driverId;

    private String name;

    private String mail;

    private String mobileNumber;

    private Long vehicleId;

    private String status; // ONLINE, OFFLINE, BUSY

    private double rating;

    public DriverDTO() {
    }

    public DriverDTO(Long driverId, String name, String mail, String mobileNumber, Long vehicleId, String status, double rating) {
        this.driverId = driverId;
        this.name = name;
        this.mail = mail;
        this.mobileNumber = mobileNumber;
        this.vehicleId = vehicleId;
        this.status = status;
        this.rating = rating;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
