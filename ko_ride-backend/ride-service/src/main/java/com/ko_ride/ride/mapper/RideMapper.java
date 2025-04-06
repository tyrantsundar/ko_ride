package com.ko_ride.ride.mapper;

import com.ko_ride.ride.dto.LocationDTO;
import com.ko_ride.ride.dto.RideDTO;
import com.ko_ride.ride.entity.Location;
import com.ko_ride.ride.entity.Ride;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.ko_ride.ride.entity.*;
@Mapper(componentModel = "spring")
public interface RideMapper {

    @Mapping(target = "startLocation", source = "startLocation")
    @Mapping(target = "targetLocation", source = "targetLocation")
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "driverId", source = "driver.driverId")
    @Mapping(target = "vehicleId", source = "vehicle.vehicleId")
    @Mapping(target = "cost", source = "fare")
    RideDTO toDTO(Ride ride);

    @Mapping(target = "startLocation", source = "startLocation")
    @Mapping(target = "targetLocation", source = "targetLocation")
    @Mapping(target = "user", source = "userId", qualifiedByName = "userFromId")
    @Mapping(target = "driver", source = "driverId", qualifiedByName = "driverFromId")
    @Mapping(target = "fare", source = "cost")
    @Mapping(target = "vehicle", source = "vehicleId", qualifiedByName = "vehicleFromId")
    @Mapping(target = "payment", ignore = true)
    Ride toEntity(RideDTO rideDTO);

    LocationDTO toLocationDTO(Location location);

    Location toLocation(LocationDTO locationDTO);

    @Named("userFromId")
    static User userFromId(Long userId) {
        if (userId == null) return null;
        User user = new User();
        user.setUserId(userId);
        return user;
    }

    @Named("driverFromId")
    static Driver driverFromId(Long driverId) {
        if (driverId == null) return null;
        Driver driver = new Driver();
        driver.setDriverId(driverId);
        return driver;
    }

    @Named("vehicleFromId")
    static Vehicle vehicleFromId(Long vehicleId){
        if(vehicleId == null) return null;
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(vehicleId);
        return vehicle;
    }
}

