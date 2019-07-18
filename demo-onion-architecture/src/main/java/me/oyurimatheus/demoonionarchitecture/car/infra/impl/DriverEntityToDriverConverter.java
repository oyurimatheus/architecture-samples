package me.oyurimatheus.demoonionarchitecture.car.infra.impl;

import me.oyurimatheus.demoonionarchitecture.car.domain.Car;
import me.oyurimatheus.demoonionarchitecture.car.domain.CarPlate;
import me.oyurimatheus.demoonionarchitecture.car.domain.Driver;
import me.oyurimatheus.demoonionarchitecture.car.infra.CarEntity;
import me.oyurimatheus.demoonionarchitecture.car.infra.DriverEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class DriverEntityToDriverConverter implements Converter<DriverEntity, Driver> {

    @Override
    public Driver convert(DriverEntity entity) {
        return new Driver(entity.getId(), entity.getName(), entity.getDriversLicense());
    }
}
