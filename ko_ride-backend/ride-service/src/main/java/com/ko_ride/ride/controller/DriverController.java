package com.ko_ride.ride.controller;

import com.ko_ride.ride.dto.DriverDTO;
import com.ko_ride.ride.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("/register")
    public ResponseEntity<DriverDTO> registerDriver(@RequestBody DriverDTO driverDTO) {
        return ResponseEntity.ok(driverService.registerDriver(driverDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDTO> getDriverById(@PathVariable Long id) {
        return driverService.getDriverById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }
}
