package com.ko_ride.ride.controller;

import com.ko_ride.ride.dto.LocationHistoryDTO;
import com.ko_ride.ride.service.LocationHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationHistoryController {

    private final LocationHistoryService locationHistoryService;

    public LocationHistoryController(LocationHistoryService locationHistoryService) {
        this.locationHistoryService = locationHistoryService;
    }

    @PostMapping("/save")
    public ResponseEntity<LocationHistoryDTO> saveLocation(@RequestBody LocationHistoryDTO locationHistoryDTO) {
        return ResponseEntity.ok(locationHistoryService.saveLocation(locationHistoryDTO));
    }

    @GetMapping("/ride/{rideId}")
    public ResponseEntity<List<LocationHistoryDTO>> getLocationHistoryByRideId(@PathVariable Long rideId) {
        return ResponseEntity.ok(locationHistoryService.getLocationHistoryByRideId(rideId));
    }
}

