package com.ko_ride.ride.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "rides")
@Entity
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ride_id")
    private Long rideId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "start_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "start_longitude"))
    })
    private Location startLocation;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "target_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "target_longitude"))
    })
    private Location targetLocation;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double distance;
    private Double fare;

    @Enumerated(EnumType.STRING)
    private RideStatus status;

    public Ride() {
    }

    public Ride(Long rideId, User user, Driver driver, Vehicle vehicle, Location startLocation, Location targetLocation, LocalDateTime startTime, LocalDateTime endTime, Double distance, Double fare, RideStatus status) {
        this.rideId = rideId;
        this.user = user;
        this.driver = driver;
        this.vehicle = vehicle;
        this.startLocation = startLocation;
        this.targetLocation = targetLocation;
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
        this.fare = fare;
        this.status = status;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(Location targetLocation) {
        this.targetLocation = targetLocation;
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

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }
}
