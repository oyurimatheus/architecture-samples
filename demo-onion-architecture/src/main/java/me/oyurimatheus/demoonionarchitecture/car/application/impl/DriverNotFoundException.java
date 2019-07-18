package me.oyurimatheus.demoonionarchitecture.car.application.impl;

class DriverNotFoundException extends IllegalArgumentException{

    DriverNotFoundException(String message) {
        super(message);
    }
}
