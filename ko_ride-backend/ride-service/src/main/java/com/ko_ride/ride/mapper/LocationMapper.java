package com.ko_ride.ride.mapper;

import com.ko_ride.ride.dto.DriverDTO;
import com.ko_ride.ride.dto.LocationDTO;
import com.ko_ride.ride.entity.Driver;
import com.ko_ride.ride.entity.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDTO toDTO(Location location);
    Location toEntity(LocationDTO locationDTO);
}
