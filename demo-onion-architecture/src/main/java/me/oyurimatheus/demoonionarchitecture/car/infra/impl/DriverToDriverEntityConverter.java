package me.oyurimatheus.demoonionarchitecture.car.infra.impl;

import me.oyurimatheus.demoonionarchitecture.car.domain.Driver;
import me.oyurimatheus.demoonionarchitecture.car.infra.DriverEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class DriverToDriverEntityConverter implements Converter<Driver, DriverEntity> {

    @Override
    public DriverEntity convert(Driver driver) {
        return new DriverEntity(driver.getId(), driver.getName(), driver.getDriversLicense());
    }
}
