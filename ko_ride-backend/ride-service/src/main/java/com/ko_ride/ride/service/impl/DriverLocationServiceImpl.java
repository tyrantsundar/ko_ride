package com.ko_ride.ride.service.impl;

import com.ko_ride.ride.dto.DriverLocationRequest;
import com.ko_ride.ride.dto.NearbyDriversRequest;
import com.ko_ride.ride.dto.NearbyDriversResponse;
import com.ko_ride.ride.quad.Point;
import com.ko_ride.ride.quad.QuadTree;
import com.ko_ride.ride.quad.Rectangle;
import com.ko_ride.ride.service.DriverLocationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DriverLocationServiceImpl implements DriverLocationService {

    private final QuadTree quadTree;

    public DriverLocationServiceImpl() {
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

            double distance = haversine(lat, lon, p.getLat(), p.getLon());
            System.out.println("Driver :: "+p.getDriverId()+" distance :: "+distance);
            if (distance <= radius) {
                result.add(new NearbyDriversResponse(p.getDriverId(), distance));
            }
        }

        result.sort(Comparator.comparingDouble(NearbyDriversResponse::getDistanceInKm));
        return result;
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371; // Earth radius in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }

}
