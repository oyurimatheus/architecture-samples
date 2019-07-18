package me.oyurimatheus.demoonionarchitecture.car.view;

import me.oyurimatheus.demoonionarchitecture.car.domain.CarPlate;
import me.oyurimatheus.demoonionarchitecture.car.domain.CarTransmission;
import me.oyurimatheus.demoonionarchitecture.car.domain.CarType;
import me.oyurimatheus.demoonionarchitecture.car.domain.Driver;

import java.util.UUID;

class CarResponse {

    private final UUID id;
    private final Driver driver;
    private final CarPlate plate;
    private final CarTransmission transmission;
    private final CarType type;
    private final String chasi;
    private final Integer odometer;

    CarResponse(UUID id, Driver driver, CarPlate plate, CarTransmission transmission, CarType type, String chasi, Integer odometer) {
        this.id = id;
        this.driver = driver;
        this.plate = plate;
        this.transmission = transmission;
        this.type = type;
        this.chasi = chasi;
        this.odometer = odometer;
    }

    public UUID getId() {
        return id;
    }

    public Driver getDriver() {
        return driver;
    }

    public CarPlate getPlate() {
        return plate;
    }

    public CarTransmission getTransmission() {
        return transmission;
    }

    public CarType getType() {
        return type;
    }

    public String getChasi() {
        return chasi;
    }

    public Integer getOdometer() {
        return odometer;
    }
}
