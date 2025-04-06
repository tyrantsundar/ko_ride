package com.ko_ride.ride.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ko_ride.ride.dto.RideDTO;
import com.ko_ride.ride.service.RideService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rides")
public class RideController {

    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping("/request")
    public ResponseEntity<RideDTO> requestRide(@RequestBody RideDTO rideDTO) throws JsonProcessingException {
        return ResponseEntity.ok(rideService.requestRide(rideDTO));
    }

    @PostMapping("/accept")
    public ResponseEntity<String> acceptRide(@RequestParam Long rideId, @RequestParam Long driverId){
        boolean accepted = rideService.acceptRide(rideId, driverId);
        if (accepted) {
            return ResponseEntity.ok("Ride accepted by Driver " + driverId);
        } else {
            return ResponseEntity.status(409).body("Ride already accepted or unavailable");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RideDTO> getRideById(@PathVariable Long id) {
        return rideService.getRideById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RideDTO>> getUserRideHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(rideService.getUserRideHistory(userId));
    }

    @GetMapping("/driver/{driverId}")
    public ResponseEntity<List<RideDTO>> getDriverRideHistory(@PathVariable Long driverId) {
        return ResponseEntity.ok(rideService.getDriverRideHistory(driverId));
    }
}

