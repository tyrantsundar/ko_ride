package com.ko_ride.ride.service.impl;

import com.ko_ride.ride.dto.LocationHistoryDTO;
import com.ko_ride.ride.entity.LocationHistory;
import com.ko_ride.ride.mapper.LocationHistoryMapper;
import com.ko_ride.ride.repository.LocationHistoryRepository;
import com.ko_ride.ride.service.LocationHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationHistoryServiceImpl implements LocationHistoryService {

    private final LocationHistoryRepository locationHistoryRepository;
    private final LocationHistoryMapper locationHistoryMapper;

    public LocationHistoryServiceImpl(LocationHistoryRepository locationHistoryRepository, LocationHistoryMapper locationHistoryMapper) {
        this.locationHistoryRepository = locationHistoryRepository;
        this.locationHistoryMapper = locationHistoryMapper;
    }

    @Override
    public LocationHistoryDTO saveLocation(LocationHistoryDTO locationHistoryDTO) {
        LocationHistory locationHistory = locationHistoryMapper.toEntity(locationHistoryDTO);
        LocationHistory savedLocation = locationHistoryRepository.save(locationHistory);
        return locationHistoryMapper.toDTO(savedLocation);
    }

    @Override
    public List<LocationHistoryDTO> getLocationHistoryByRideId(Long rideId) {
        return locationHistoryRepository.findByRideId(rideId).stream()
                .map(locationHistoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}


