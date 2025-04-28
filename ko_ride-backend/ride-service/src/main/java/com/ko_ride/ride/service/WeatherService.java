package com.ko_ride.ride.service;

import com.ko_ride.ride.model.WeatherInfo;

public interface WeatherService {
    WeatherInfo getCurrentWeather(double latitude, double longitude);
}
