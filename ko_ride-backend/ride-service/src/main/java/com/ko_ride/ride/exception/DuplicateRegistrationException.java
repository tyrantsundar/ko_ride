package com.ko_ride.ride.exception;

public class DuplicateRegistrationException extends RuntimeException{
    public DuplicateRegistrationException(String entity, String duplicateKey) {
        super(String.format(entity+" already existed with "+duplicateKey));
    }
}
