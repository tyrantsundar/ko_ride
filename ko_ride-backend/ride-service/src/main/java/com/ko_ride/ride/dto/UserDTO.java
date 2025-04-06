package com.ko_ride.ride.dto;


public class UserDTO {
    private Long userId;
    private String name;
    private String mail;
    private String mobileNumber;
    private String passWord;

    public UserDTO() {
    }

    public UserDTO(Long userId, String name, String mail, String mobileNumber, String passWord) {
        this.userId = userId;
        this.name = name;
        this.mail = mail;
        this.mobileNumber = mobileNumber;
        this.passWord = passWord;
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
}
