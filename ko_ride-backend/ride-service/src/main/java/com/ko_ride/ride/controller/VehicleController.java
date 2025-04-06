package com.ko_ride.ride.controller;

import com.ko_ride.ride.dto.VehicleDTO;
import com.ko_ride.ride.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping("/register")
    public ResponseEntity<VehicleDTO> registerVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.registerVehicle(vehicleDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDTO> getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

