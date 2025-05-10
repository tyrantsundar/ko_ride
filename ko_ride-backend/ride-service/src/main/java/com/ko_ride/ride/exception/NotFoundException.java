package com.ko_ride.ride.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String entity, String key) {
        super(String.format(entity+" not found with key "+key));
    }
}
