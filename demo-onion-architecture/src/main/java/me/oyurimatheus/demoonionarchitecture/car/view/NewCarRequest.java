package me.oyurimatheus.demoonionarchitecture.car.view;

import me.oyurimatheus.demoonionarchitecture.car.domain.CarPlate;
import me.oyurimatheus.demoonionarchitecture.car.domain.CarTransmission;
import me.oyurimatheus.demoonionarchitecture.car.domain.CarType;

import java.util.UUID;

public class NewCarRequest {

    private final UUID driversId;
    private final String plateLetters;
    private final String plateNumbers;
    private final String plateState;
    private final String plateCity;
    private final Integer odometer;
    private final String chasi;
    private final CarType type;
    private final CarTransmission transmission;

    public NewCarRequest(UUID driversId, String plateLetters, String plateNumbers, String plateState, String plateCity, Integer odometer, String chasi, CarType type, CarTransmission transmission) {
        this.driversId = driversId;
        this.plateLetters = plateLetters;
        this.plateNumbers = plateNumbers;
        this.plateState = plateState;
        this.plateCity = plateCity;
        this.odometer = odometer;
        this.chasi = chasi;
        this.type = type;
        this.transmission = transmission;
    }

    public UUID getDriversId() {
        return driversId;
    }

    public String getPlateLetters() {
        return plateLetters;
    }

    public String getPlateNumbers() {
        return plateNumbers;
    }

    public String getPlateState() {
        return plateState;
    }

    public String getPlateCity() {
        return plateCity;
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
