package com.ko_ride.notification.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "drivers")
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    private String name;

    private String mail;

    private String mobileNumber;

    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL)
    private Vehicle vehicle;
    /**
     * 1        1
     * Driver   Vehicle
     * 1        1
     * */

    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL)
    private List<Ride> rides;
    /**
     * 1        M
     * Driver   Ride
     * 1        1
     * */

    public Driver() {
    }

    public Driver(Long driverId, String name, String mail, String mobileNumber, Vehicle vehicle, List<Ride> rides) {
        this.driverId = driverId;
        this.name = name;
        this.mail = mail;
        this.mobileNumber = mobileNumber;
        this.vehicle = vehicle;
        this.rides = rides;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
