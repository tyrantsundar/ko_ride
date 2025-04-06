package com.ko_ride.ride.mapper;

import com.ko_ride.ride.dto.LocationHistoryDTO;
import com.ko_ride.ride.entity.LocationHistory;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface LocationHistoryMapper {
    LocationHistoryDTO toDTO(LocationHistory locationHistory);
    LocationHistory toEntity(LocationHistoryDTO locationHistoryDTO);
}
