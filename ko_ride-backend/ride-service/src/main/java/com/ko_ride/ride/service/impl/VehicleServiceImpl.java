package com.ko_ride.ride.service.impl;

import com.ko_ride.ride.dto.VehicleDTO;
import com.ko_ride.ride.entity.Driver;
import com.ko_ride.ride.entity.Vehicle;
import com.ko_ride.ride.mapper.VehicleMapper;
import com.ko_ride.ride.repository.DriverRepository;
import com.ko_ride.ride.repository.VehicleRepository;
import com.ko_ride.ride.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;
    private final DriverRepository driverRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper, DriverRepository driverRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
        this.driverRepository = driverRepository;
    }

    @Override
    public VehicleDTO registerVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleMapper.toEntity(vehicleDTO);
        Long driverId = vehicleDTO.getDriverId();
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        vehicle.setDriver(driver);
//        driver.setVehicle(vehicle);
//        driverRepository.save(driver);

        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return vehicleMapper.toDTO(savedVehicle);
    }

    @Override
    public Optional<VehicleDTO> getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId).map(vehicleMapper::toDTO);
    }
}


