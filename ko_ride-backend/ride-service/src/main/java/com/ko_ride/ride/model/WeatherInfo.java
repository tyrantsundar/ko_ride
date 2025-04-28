package com.ko_ride.ride.model;

public class WeatherInfo {
    private String description;
    private double temperatureInCelsius;
    private double windSpeed;
    private boolean isRaining;
    private double rainVolumeLastHour;

    public WeatherInfo() {
    }

    public WeatherInfo(String description, double temperatureInCelsius, double windSpeed, boolean isRaining, double rainVolumeLastHour) {
        this.description = description;
        this.temperatureInCelsius = temperatureInCelsius;
        this.windSpeed = windSpeed;
        this.isRaining = isRaining;
        this.rainVolumeLastHour = rainVolumeLastHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(double temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public boolean isRaining() {
        return isRaining;
    }

    public void setRaining(boolean raining) {
        isRaining = raining;
    }

    public double getRainVolumeLastHour() {
        return rainVolumeLastHour;
    }

    public void setRainVolumeLastHour(double rainVolumeLastHour) {
        this.rainVolumeLastHour = rainVolumeLastHour;
    }

    // getters, setters

    public static WeatherInfo fromApiResponse(WeatherApiResponse response) {
        WeatherInfo info = new WeatherInfo();
        if (response.getWeather() != null && !response.getWeather().isEmpty()) {
            info.setDescription(response.getWeather().get(0).getDescription());
            info.setRaining(response.getWeather().get(0).getMain().toLowerCase().contains("rain"));
        }
        if (response.getMain() != null) {
            // OpenWeather gives temperature in Kelvin, converting to Celsius
            info.setTemperatureInCelsius(response.getMain().getTemp() - 273.15);
        }
        if (response.getWind() != null) {
            info.setWindSpeed(response.getWind().getSpeed());
        }
        if (response.getRain() != null) {
            info.setRainVolumeLastHour(response.getRain().get1h());
        }
        return info;
    }
}

