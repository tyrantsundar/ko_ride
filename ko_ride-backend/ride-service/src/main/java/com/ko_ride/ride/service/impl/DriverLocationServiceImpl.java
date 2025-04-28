package com.ko_ride.ride.service.impl;

import com.ko_ride.ride.dto.DriverDTO;
import com.ko_ride.ride.dto.DriverLocationRequest;
import com.ko_ride.ride.dto.NearbyDriversRequest;
import com.ko_ride.ride.dto.NearbyDriversResponse;
import com.ko_ride.ride.model.WeatherInfo;
import com.ko_ride.ride.quad.Point;
import com.ko_ride.ride.quad.QuadTree;
import com.ko_ride.ride.quad.Rectangle;
import com.ko_ride.ride.service.DriverLocationService;
import com.ko_ride.ride.service.DriverService;
import com.ko_ride.ride.service.WeatherService;
import com.ko_ride.ride.util.DistanceUtil;
import org.springframework.data.geo.Distance;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DriverLocationServiceImpl implements DriverLocationService {

    private final QuadTree quadTree;

    private DriverService driverService;

    private WeatherService weatherService;

    public DriverLocationServiceImpl(DriverService driverService, WeatherService weatherService) {
        this.driverService = driverService;
        this.weatherService = weatherService;
        // Initial boundary can be the whole city or country range (ex: India map bounds)
        this.quadTree = new QuadTree(
                new Rectangle(20.5937, 78.9629, 20, 20), 4
        );
    }

    @Override
    public boolean registerDriverLocation(DriverLocationRequest request) {
        Point driverPoint = new Point(request.getLat(), request.getLon(), request.getDriverId());
        return quadTree.insert(driverPoint);
    }

    @Override
    public List<NearbyDriversResponse> getNearbyDrivers(NearbyDriversRequest request) {
        double lat = request.getLat();
        double lon = request.getLon();
        double radius = request.getRadiusInKm();

        // Approximate bounding box in degrees
        double deltaLat = radius / 111.0; // 1 deg ≈ 111 km
        double deltaLon = radius / (111.0 * Math.cos(Math.toRadians(lat)));

        Rectangle queryArea = new Rectangle(lat, lon, deltaLat, deltaLon);
        List<Point> candidates = quadTree.query(queryArea);

        List<NearbyDriversResponse> result = new ArrayList<>();
        for (Point p : candidates) {

            Optional<DriverDTO> driverOptional = driverService.getDriverById(p.getDriverId());
            if(driverOptional.isEmpty()){
                System.out.println("Driver with id "+p.getDriverId()+" is not present in the geo point.");
                continue;
            }
            DriverDTO driverDTO = driverOptional.get();

            double distanceKm = DistanceUtil.haversine(lat, lon, p.getLat(), p.getLon());
            WeatherInfo currentWeather = weatherService.getCurrentWeather(p.getLat(), p.getLon());
            double etaInMin = DistanceUtil.calculateETA(distanceKm,driverDTO.getRating(),currentWeather, LocalTime.now());
            System.out.println("Driver :: "+p.getDriverId()+" distance :: "+distanceKm+" ETA :: "+etaInMin);

            if (distanceKm <= radius) {
                result.add(new NearbyDriversResponse(p.getDriverId(), distanceKm, etaInMin));
            }
        }

        result.sort(Comparator.comparingDouble(NearbyDriversResponse::getDistanceInKm));
        return result;
    }

}
