package com.ko_ride.ride.controller;

import com.ko_ride.ride.dto.DriverLocationRequest;
import com.ko_ride.ride.dto.NearbyDriversRequest;
import com.ko_ride.ride.dto.NearbyDriversResponse;
import com.ko_ride.ride.service.DriverLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverLocationController {

    private DriverLocationService driverLocationService;

    public DriverLocationController(DriverLocationService driverLocationService) {
        this.driverLocationService = driverLocationService;
    }

    @PostMapping("/register-location")
    public ResponseEntity<String> registerDriver(@RequestBody DriverLocationRequest request) {
        boolean inserted = driverLocationService.registerDriverLocation(request);
        return inserted
                ? ResponseEntity.ok("Driver location registered")
                : ResponseEntity.badRequest().body("Invalid location or insertion failed");
    }

    @PostMapping("/nearby-drivers")
    public ResponseEntity<List<NearbyDriversResponse>> getNearbyDrivers(@RequestBody NearbyDriversRequest request) {
        List<NearbyDriversResponse> drivers = driverLocationService.getNearbyDrivers(request);
        return ResponseEntity.ok(drivers);
    }

}
