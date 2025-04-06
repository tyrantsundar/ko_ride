package com.ko_ride.notification.entity;

import jakarta.persistence.*;

@Table(name = "notifications")
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;

    private String notificationType;

    private String mode;

    private Long notifierId;

    private String notifierType;

    private String notifierAddress;

    private boolean status;

    private Long rideId;

    public Notification() {
    }

    public Notification( String notificationType, String mode, Long notifierId, String notifierType, String notifierAddress, boolean status, Long rideId) {
        this.notificationType = notificationType;
        this.mode = mode;
        this.notifierId = notifierId;
        this.notifierType = notifierType;
        this.notifierAddress = notifierAddress;
        this.status = status;
        this.rideId = rideId;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Long getNotifierId() {
        return notifierId;
    }

    public void setNotifierId(Long notifierId) {
        this.notifierId = notifierId;
    }

    public String getNotifierType() {
        return notifierType;
    }

    public void setNotifierType(String notifierType) {
        this.notifierType = notifierType;
    }

    public String getNotifierAddress() {
        return notifierAddress;
    }

    public void setNotifierAddress(String notifierAddress) {
        this.notifierAddress = notifierAddress;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getRideId() {
        return rideId;
    }

    public void setRideId(Long rideId) {
        this.rideId = rideId;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", notificationType='" + notificationType + '\'' +
                ", mode='" + mode + '\'' +
                ", notifierId=" + notifierId +
                ", notifierType='" + notifierType + '\'' +
                ", notifierAddress='" + notifierAddress + '\'' +
                ", status=" + status +
                ", rideId=" + rideId +
                '}';
    }
}
