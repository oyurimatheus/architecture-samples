package me.oyurimatheus.demoonionarchitecture.car.domain;

import java.util.UUID;

public class Car {

    private final UUID id;
    private final Driver driver;
    private final CarPlate plate;
    private final Integer odometer;
    private final String chasi;
    private final CarType type;
    private final CarTransmission transmission;

    public Car(UUID id, Driver driver, CarPlate plate, Integer odometer, String chasi, CarType type, CarTransmission transmission) {
        this.id = id;
        this.driver = driver;
        this.plate = plate;
        this.odometer = odometer;
        this.chasi = chasi;
        this.type = type;
        this.transmission = transmission;
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

    public Integer getOdometer() {
        return odometer;
    }

    public String getChasi() {
        return chasi;
    }

    public CarType getType() {
        return type;
    }

    public CarTransmission getTransmission() {
        return transmission;
    }
}
