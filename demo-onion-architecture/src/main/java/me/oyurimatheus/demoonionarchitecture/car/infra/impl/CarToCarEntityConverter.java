package me.oyurimatheus.demoonionarchitecture.car.infra.impl;

import me.oyurimatheus.demoonionarchitecture.car.domain.Car;
import me.oyurimatheus.demoonionarchitecture.car.domain.CarPlate;
import me.oyurimatheus.demoonionarchitecture.car.domain.Driver;
import me.oyurimatheus.demoonionarchitecture.car.infra.CarEntity;
import me.oyurimatheus.demoonionarchitecture.car.infra.DriverEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarToCarEntityConverter implements Converter<Car,CarEntity> {

    private final Converter<Driver, DriverEntity> driverToDriverEntity;

    public CarToCarEntityConverter(Converter<Driver, DriverEntity> driverToDriverEntity) {
        this.driverToDriverEntity = driverToDriverEntity;
    }

    @Override
    public CarEntity convert(Car car) {
        CarPlate plate = car.getPlate();

        DriverEntity driverEntity = driverToDriverEntity.convert(car.getDriver());

        return new CarEntity(car.getId(),
                       plate.getLetters(),
                       plate.getNumbers(),
                       plate.getState(),
                       plate.getCity(),
                       driverEntity,
                       car.getOdometer(),
                       car.getChasi(),
                       car.getType(),
                       car.getTransmission());
    }
}
