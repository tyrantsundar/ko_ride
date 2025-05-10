package com.ko_ride.ride.exception;

public class InvalidVehicleMappingException extends RuntimeException{
    public InvalidVehicleMappingException(String driver, String vehicle) {
        super(String.format("Vehicle "+vehicle+" is already mapped with driver "+driver));
    }
}
