package com.ko_ride.ride.entity;

import jakarta.persistence.*;

@Entity
@Table
public class RideRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @OneToOne(mappedBy = "rideRating", cascade = CascadeType.ALL)
    private Ride ride;

    private double vehicleRating;

    private double driverRating;

    private double userRating;

    private String driverFeedBack;

    private String userFeedBack;

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public double getVehicleRating() {
        return vehicleRating;
    }

    public void setVehicleRating(double vehicleRating) {
        this.vehicleRating = vehicleRating;
    }

    public double getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(double driverRating) {
        this.driverRating = driverRating;
    }

    public double getUserRating() {
        return userRating;
    }

    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }

    public String getDriverFeedBack() {
        return driverFeedBack;
    }

    public void setDriverFeedBack(String driverFeedBack) {
        this.driverFeedBack = driverFeedBack;
    }

    public String getUserFeedBack() {
        return userFeedBack;
    }

    public void setUserFeedBack(String userFeedBack) {
        this.userFeedBack = userFeedBack;
    }
}
