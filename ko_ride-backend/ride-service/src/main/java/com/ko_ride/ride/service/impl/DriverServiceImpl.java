package com.ko_ride.ride.service.impl;

import com.ko_ride.ride.dto.DriverDTO;
import com.ko_ride.ride.entity.Driver;
import com.ko_ride.ride.mapper.DriverMapper;
import com.ko_ride.ride.repository.DriverRepository;
import com.ko_ride.ride.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    @Override
    public DriverDTO registerDriver(DriverDTO driverDTO) {
        Driver driver = driverMapper.toEntity(driverDTO);
        Driver savedDriver = driverRepository.save(driver);
        return driverMapper.toDTO(savedDriver);
    }

    @Override
    public Optional<DriverDTO> getDriverById(Long driverId) {
        return driverRepository.findById(driverId).map(driverMapper::toDTO);
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return driverRepository.findAll().stream()
                .map(driverMapper::toDTO)
                .collect(Collectors.toList());
    }

}


