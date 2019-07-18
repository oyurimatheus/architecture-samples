package me.oyurimatheus.demoonionarchitecture.car.domain;

import java.util.UUID;

public class Driver {

    private final UUID id;
    private final String name;
    private final String driversLicense;

    public Driver(UUID id, String name, String driversLicense) {
        this.id = id;
        this.name = name;
        this.driversLicense = driversLicense;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDriversLicense() {
        return driversLicense;
    }
}
