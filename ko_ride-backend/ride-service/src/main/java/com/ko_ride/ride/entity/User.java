package com.ko_ride.ride.entity;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "users")
@Entity

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String mail;

    private String mobileNumber;

    private String passWord;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Ride> rides;
    /**
     * 1        M
     * User     Ride
     * 1        1
     * **/


    public User() {

    }

    public User(Long userId, String name, String mail, String mobileNumber, String passWord, List<Ride> rides) {
        this.userId = userId;
        this.name = name;
        this.mail = mail;
        this.mobileNumber = mobileNumber;
        this.passWord = passWord;
        this.rides = rides;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }
}
