package com.ko_ride.ride.entity;

import jakarta.persistence.*;

@Table(name = "vehicles")
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    private String vehicleNumber;

    @OneToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    private String type;

    public Vehicle() {
    }

    public Vehicle(Long vehicleId, String vehicleNumber, Driver driver) {
        this.vehicleId = vehicleId;
        this.vehicleNumber = vehicleNumber;
        this.driver = driver;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
