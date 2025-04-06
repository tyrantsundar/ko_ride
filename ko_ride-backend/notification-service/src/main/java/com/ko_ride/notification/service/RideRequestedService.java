package com.ko_ride.notification.service;

import com.ko_ride.notification.entity.Driver;
import com.ko_ride.notification.entity.Notification;
import com.ko_ride.notification.event.RideRequestedEvent;
import com.ko_ride.notification.repository.DriverRepository;
import com.ko_ride.notification.repository.NotificationRepository;
import com.ko_ride.notification.strategy.DriverFilterStrategy;
import com.ko_ride.notification.strategy.DriverFilterStrategyEnum;
import com.ko_ride.notification.strategy.DriverFilterStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RideRequestedService {
    private final DriverRepository driverRepository;
    private final NotificationRepository notificationRepository;

    public RideRequestedService(DriverRepository driverRepository, NotificationRepository notificationRepository) {
        this.driverRepository = driverRepository;
        this.notificationRepository = notificationRepository;
    }

    public void notifyDrivers(RideRequestedEvent rideRequestedEvent){
        DriverFilterStrategy driverFilterStrategy = DriverFilterStrategyFactory.getDriverFilterStrategy(DriverFilterStrategyEnum.ALL);
        List<Driver> allDrivers = driverRepository.findAll();
        if (allDrivers.isEmpty()) {
            log.warn("No drivers found to notify for ride ID {}", rideRequestedEvent.getRideId());
            return;
        }
        List<Driver> filteredDrivers = driverFilterStrategy.getDrivers(rideRequestedEvent, allDrivers);
        filteredDrivers.stream()
                .forEach(driver -> sendSMSToDriver(driver,rideRequestedEvent));
    }

    public void sendSMSToDriver(Driver driver, RideRequestedEvent rideRequestedEvent){
        String notificationType = "RIDE-REQUEST";
        String mode = "SMS";
        Long notifierId = driver.getDriverId();
        String notifierType = "DRIVER";
        String notifierAddress = driver.getMobileNumber();
        boolean status = true;
        Long rideId = rideRequestedEvent.getRideId();
        Notification notification = new Notification(notificationType, mode, notifierId, notifierType, notifierAddress, status, rideId);
        Notification savedNotification = notificationRepository.save(notification);
        log.info("Notification sent for Ride Id {} to Driver Id {} via {} on {}. SavedNotification {}", rideId, notifierId, mode, notifierAddress, savedNotification);
    }
}
