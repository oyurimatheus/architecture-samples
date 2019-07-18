package me.oyurimatheus.demoonionarchitecture.car.infra.impl;

import me.oyurimatheus.demoonionarchitecture.car.domain.Car;
import me.oyurimatheus.demoonionarchitecture.car.domain.CarPlate;
import me.oyurimatheus.demoonionarchitecture.car.domain.Driver;
import me.oyurimatheus.demoonionarchitecture.car.infra.CarEntity;
import me.oyurimatheus.demoonionarchitecture.car.infra.DriverEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CarEntityToCarConverter implements Converter<CarEntity, Car> {

    private final Converter<DriverEntity, Driver> driverEntityToDriver;

    public CarEntityToCarConverter(Converter<DriverEntity, Driver> driverEntityToDriver) {
        this.driverEntityToDriver = driverEntityToDriver;
    }

    @Override
    public Car convert(CarEntity entity) {
        Driver driver = driverEntityToDriver.convert(entity.getDriver());

        return new Car(entity.getId(),
                       driver,
                       new CarPlate(entity.getPlateLetters(), entity.getPlateNumbers(), entity.getPlateState(), entity.getPlateCity()),
                       entity.getOdometer(),
                       entity.getChasi(),
                       entity.getType(),
                       entity.getTransmission());
    }
}
