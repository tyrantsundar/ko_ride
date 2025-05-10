package com.ko_ride.ride.mapper;

import com.ko_ride.ride.dto.DriverDTO;
import com.ko_ride.ride.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    @Mapping(source = "status", target = "status")
    @Mapping(source = "vehicle.vehicleId", target = "vehicleId") // optional, for vehicleId
    DriverDTO toDTO(Driver driver);

    @Mapping(source = "status", target = "status")
    Driver toEntity(DriverDTO driverDTO);
}

