package com.ko_ride.ride.mapper;

import com.ko_ride.ride.dto.VehicleDTO;
import com.ko_ride.ride.entity.Driver;
import com.ko_ride.ride.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    @org.mapstruct.Mapping(target = "driverId", source = "driver.driverId")
    VehicleDTO toDTO(Vehicle vehicle);

    @org.mapstruct.Mapping(target = "driver", source = "driverId", qualifiedByName = "driverFromId")
    Vehicle toEntity(VehicleDTO vehicleDTO);

    @Named("driverFromId")
    static Driver driverFromId(Long driverId) {
        if (driverId == null) return null;
        Driver driver = new Driver();
        driver.setDriverId(driverId);
        return driver;
    }
}

