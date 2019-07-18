package me.oyurimatheus.demoonionarchitecture.car.infra.impl;

import me.oyurimatheus.demoonionarchitecture.car.domain.Driver;
import me.oyurimatheus.demoonionarchitecture.car.infra.DriverEntity;
import me.oyurimatheus.demoonionarchitecture.car.infra.FindDriverRepository;
import me.oyurimatheus.demoonionarchitecture.car.infra.SaveDriverRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
class SqlDriverRepository implements FindDriverRepository, SaveDriverRepository {

    private final DriverRepository driverRepository;
    private final Converter<DriverEntity, Driver> driverEntityToDriver;
    private final Converter<Driver, DriverEntity> driverToDriverEntity;

    SqlDriverRepository(DriverRepository driverRepository, Converter<DriverEntity, Driver> driverEntityToDriver, Converter<Driver, DriverEntity> driverToDriverEntity) {
        this.driverRepository = driverRepository;
        this.driverEntityToDriver = driverEntityToDriver;
        this.driverToDriverEntity = driverToDriverEntity;
    }

    @Override
    public Optional<Driver> findDriverById(UUID id) {
        Optional<DriverEntity> driver = driverRepository.findById(id);

        if(driver.isEmpty())
            return Optional.empty();

        DriverEntity driverEntity = driver.get();

        return Optional.of(driverEntityToDriver.convert(driverEntity));
    }

    @Override
    public Driver save(Driver driver) {
        DriverEntity entity = driverToDriverEntity.convert(driver);

        DriverEntity saved = driverRepository.save(entity);
        return driverEntityToDriver.convert(saved);
    }
}
