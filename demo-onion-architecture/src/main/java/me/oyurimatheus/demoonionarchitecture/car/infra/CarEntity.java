package me.oyurimatheus.demoonionarchitecture.car.infra;

import me.oyurimatheus.demoonionarchitecture.car.domain.CarTransmission;
import me.oyurimatheus.demoonionarchitecture.car.domain.CarType;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "cars")
@Entity
public class CarEntity {

    @Id
    private UUID id;
    private String plateLetters;
    private String plateNumbers;
    private String plateState;
    private String plateCity;
    @OneToOne
    @MapsId
    private DriverEntity driver;
    private Integer odometer;
    private String chasi;
    private CarType type;
    private CarTransmission transmission;


    public CarEntity(UUID id, String plateLetters, String plateNumbers, String plateState, String plateCity, DriverEntity driver, Integer odometer, String chasi, CarType type, CarTransmission transmission) {
        this.id = id;
        this.plateLetters = plateLetters;
        this.plateNumbers = plateNumbers;
        this.plateState = plateState;
        this.plateCity = plateCity;
        this.driver = driver;
        this.odometer = odometer;
        this.chasi = chasi;
        this.type = type;
        this.transmission = transmission;
    }

    /**
     * @deprecated frameworks eyes only
     */
    private CarEntity() {}

    public UUID getId() {
        return id;
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

    public DriverEntity getDriver() {
        return driver;
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
