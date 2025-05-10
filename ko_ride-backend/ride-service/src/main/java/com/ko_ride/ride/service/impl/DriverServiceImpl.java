package com.ko_ride.ride.service.impl;

import com.ko_ride.ride.dto.DriverDTO;
import com.ko_ride.ride.entity.Driver;
import com.ko_ride.ride.entity.Vehicle;
import com.ko_ride.ride.exception.DuplicateRegistrationException;
import com.ko_ride.ride.exception.InvalidVehicleMappingException;
import com.ko_ride.ride.exception.NotFoundException;
import com.ko_ride.ride.mapper.DriverMapper;
import com.ko_ride.ride.repository.DriverRepository;
import com.ko_ride.ride.repository.VehicleRepository;
import com.ko_ride.ride.service.DriverService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final VehicleRepository vehicleRepository;
    private final DriverMapper driverMapper;

    public DriverServiceImpl(DriverRepository driverRepository, DriverMapper driverMapper, VehicleRepository vehicleRepository) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public DriverDTO registerDriver(DriverDTO driverDTO) {
        if(!driverRepository.findByMail(driverDTO.getMail()).isEmpty()){
            throw new DuplicateRegistrationException("Driver", driverDTO.getMail());
        }
        if(!driverRepository.findByMobileNumber(driverDTO.getMobileNumber()).isEmpty()){
            throw new DuplicateRegistrationException("Driver", driverDTO.getMobileNumber());
        }
        Driver driver = driverMapper.toEntity(driverDTO);
        if(driverDTO.getVehicleId() != null) {
            Optional<Vehicle> optionalVehicle = vehicleRepository.findById(driverDTO.getVehicleId());
            if (optionalVehicle.isEmpty()) {
                throw new NotFoundException("Vehicle ", String.valueOf(driverDTO.getVehicleId()));
            }
            Vehicle vehicle = optionalVehicle.get();
            if (Objects.nonNull(vehicle) && vehicle.getDriver().getDriverId() != driverDTO.getDriverId()) {
                throw new InvalidVehicleMappingException(driverDTO.getMail(), vehicle.getVehicleNumber());
            }
            driver.setVehicle(vehicle);
        }
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


