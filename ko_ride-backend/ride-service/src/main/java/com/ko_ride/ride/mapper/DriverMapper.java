package com.ko_ride.ride.mapper;

import com.ko_ride.ride.dto.DriverDTO;
import com.ko_ride.ride.entity.Driver;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    DriverDTO toDTO(Driver driver);
    Driver toEntity(DriverDTO driverDTO);
}

