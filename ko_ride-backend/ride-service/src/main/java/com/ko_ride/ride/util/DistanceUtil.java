package com.ko_ride.ride.util;

import java.time.LocalTime;
import java.util.Random;

import static org.hibernate.annotations.UuidGenerator.Style.RANDOM;

public class DistanceUtil {

    private static final double EARTH_RADIUS_KM = 6371.0; // Radius of Earth in kilometers

    private static final double AVERAGE_SPEED_KMPH = 30.0; // Assume average city speed

    private static final Random RANDOM = new Random();
//
//    private static final double TIME_OF_DAY_FACTOR = 1.0;
//
//    private static final double WEATHER_FACTOR = 1.0;
//
//    private static final double DRIVER_PROFILE_FACTOR = 1.0;
//
//    private static final double TRAFFIC_FACTOR = 1.0;

    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Convert degrees to radians
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        // Haversine formula
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Distance in kilometers
        return EARTH_RADIUS_KM * c;
    }

    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.pow(Math.sin(dLon / 2), 2) *
                        Math.cos(lat1) * Math.cos(lat2);

        double c = 2 * Math.asin(Math.sqrt(a));

        return EARTH_RADIUS_KM * c; // Distance in km
    }

//    public static double calculateETA(double distanceKm) {
//       double effective_speed = AVERAGE_SPEED_KMPH
//                  * TIME_OF_DAY_FACTOR
//                  * WEATHER_FACTOR
//                  * DRIVER_PROFILE_FACTOR
//                  * TRAFFIC_FACTOR;
//
//        double speedKmpMin = effective_speed / 60.0; // Convert speed to km per minute
//        return distanceKm / speedKmpMin; // ETA in minutes
//    }

    public static double calculateETA(double distanceKm, double driverRating, String weather, LocalTime timeOfDay) {
        double effectiveSpeed = calculateEffectiveSpeed(driverRating, weather, timeOfDay);
        double speedKmPerMin = effectiveSpeed / 60.0;
        return distanceKm / speedKmPerMin;
    }

    public static double calculateEffectiveSpeed(double driverRating, String weather, LocalTime timeOfDay) {
        double timeFactor = getTimeOfDayFactor(timeOfDay);
        double weatherFactor = getWeatherFactor(weather);
        double driverFactor = getDriverProfileFactor(driverRating);
        double trafficFactor = getRandomTrafficFactor();

        return AVERAGE_SPEED_KMPH * timeFactor * weatherFactor * driverFactor * trafficFactor;
    }

    // Adjust speed based on time of day
    private static double getTimeOfDayFactor(LocalTime timeOfDay) {
        int hour = timeOfDay.getHour();
        if (hour >= 7 && hour <= 10) { // Morning rush
            return 0.7;
        } else if (hour >= 17 && hour <= 20) { // Evening rush
            return 0.7;
        } else if (hour >= 22 || hour <= 5) { // Late night
            return 1.2;
        }
        return 1.0; // Normal times
    }

    // Adjust speed based on weather conditions
    private static double getWeatherFactor(String weather) {
        if (weather == null) {
            return 1.0;
        }
        weather = weather.toLowerCase();
        if (weather.contains("rain") || weather.contains("storm") || weather.contains("snow")) {
            return 0.8;
        }
        return 1.0; // Clear or normal weather
    }

    // Adjust speed based on driver profile (rating out of 5)
    private static double getDriverProfileFactor(double driverRating) {
        if (driverRating >= 4.5) {
            return 1.1; // Fast and efficient driver
        } else if (driverRating <= 3.0) {
            return 0.9; // Cautious or slower driver
        }
        return 1.0; // Average drivers
    }

    // Add random small variation for traffic
    private static double getRandomTrafficFactor() {
        // Random between 0.8 and 1.2
        return 0.8 + (RANDOM.nextDouble() * 0.4);
    }
}
