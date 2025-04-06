package com.ko_ride.ride.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ko_ride.ride.dto.RideDTO;
import com.ko_ride.ride.entity.*;
import com.ko_ride.ride.event.EventPublisher;
import com.ko_ride.ride.event.NotificationTopicsConfig;
import com.ko_ride.ride.event.RideRequestedEvent;
import com.ko_ride.ride.mapper.RideMapper;
import com.ko_ride.ride.repository.DriverRepository;
import com.ko_ride.ride.repository.RideRepository;
import com.ko_ride.ride.repository.UserRepository;
import com.ko_ride.ride.repository.VehicleRepository;
import com.ko_ride.ride.service.RideService;
import com.ko_ride.ride.util.DistanceUtil;
import com.ko_ride.ride.util.EventUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final RideMapper rideMapper;
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;
    private final NotificationTopicsConfig topicsConfig;
    private final ObjectMapper objectMapper;
    private final EventPublisher eventPublisher;

    public RideServiceImpl(RideRepository rideRepository, RideMapper rideMapper, UserRepository userRepository,
                           DriverRepository driverRepository, VehicleRepository vehicleRepository,
                           NotificationTopicsConfig topicsConfig, ObjectMapper objectMapper,
                           EventPublisher eventPublisher) {
        this.rideRepository = rideRepository;
        this.rideMapper = rideMapper;
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;
        this.topicsConfig = topicsConfig;
        this.objectMapper = objectMapper;
        this.eventPublisher = eventPublisher;
    }

    @Override
    public RideDTO requestRide(RideDTO rideDTO) throws JsonProcessingException {
        Ride ride = rideMapper.toEntity(rideDTO);

        User user = userRepository.findById(ride.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found."));
        ride.setUser(user);

//        Driver driver = driverRepository.findById(ride.getDriver().getDriverId())
//                .orElseThrow(() -> new RuntimeException("Driver not found."));
        //Because while requesting user doesnt know who is going to be the driver
        ride.setDriver(null);

//        Vehicle vehicle= vehicleRepository.findById(ride.getVehicle().getVehicleId())
//                .orElseThrow(() -> new RuntimeException("Vehicle not found"));
        //Because while requesting user doesnt know which is going to be the vehicle
        ride.setVehicle(null);

        double distance = DistanceUtil.calculateDistance(
                ride.getStartLocation().getLatitude(),
                ride.getStartLocation().getLongitude(),
                ride.getTargetLocation().getLatitude(),
                ride.getTargetLocation().getLongitude()
        );
        ride.setDistance(distance);
        ride.setFare(distance * 10);


        Ride savedRide = rideRepository.save(ride);
        RideRequestedEvent event = EventUtil.createRideRequestedEvent(savedRide);

        String eventString = objectMapper.writeValueAsString(event);
        eventPublisher.publishEvent(topicsConfig.getTripRequest(), eventString);
        return rideMapper.toDTO(savedRide);
    }

    @Override
    public boolean acceptRide(Long rideId, Long driverId) {
        Optional<Ride> rideOpt = rideRepository.findById(rideId);
        if (rideOpt.isEmpty()) return false;

        Ride ride = rideOpt.get();
        if (ride.getStatus() != RideStatus.REQUESTED) {
            return false;
        }


        Optional<Driver> driverOpt = driverRepository.findById(driverId);
        if(driverOpt.isEmpty()) return false;

        Driver driver = driverOpt.get();
        ride.setDriver(driver);
        ride.setVehicle(driver.getVehicle());
        ride.setStatus(RideStatus.ACCEPTED);
        rideRepository.save(ride);
        return true;
    }

    @Override
    public Optional<RideDTO> getRideById(Long rideId) {
        return rideRepository.findById(rideId).map(rideMapper::toDTO);
    }

    @Override
    public List<RideDTO> getUserRideHistory(Long userId) {
        return rideRepository.findByUser_userId(userId).stream()
                .map(rideMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RideDTO> getDriverRideHistory(Long driverId) {
        return rideRepository.findByDriver_driverId(driverId).stream()
                .map(rideMapper::toDTO)
                .collect(Collectors.toList());
    }

}


