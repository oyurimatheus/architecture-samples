package me.oyurimatheus.demoonionarchitecture.car.application.impl;

import me.oyurimatheus.demoonionarchitecture.car.domain.CarPlate;
import me.oyurimatheus.demoonionarchitecture.car.infra.FindDriverRepository;
import me.oyurimatheus.demoonionarchitecture.car.domain.Car;
import me.oyurimatheus.demoonionarchitecture.car.domain.Driver;
import me.oyurimatheus.demoonionarchitecture.car.view.NewCarRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
class NewCarRequestToCarConverter implements Converter<NewCarRequest, Car> {

    private final FindDriverRepository findDriverRepository;

    public NewCarRequestToCarConverter(FindDriverRepository findDriverRepository) {
        this.findDriverRepository = findDriverRepository;
    }

    @Override
    public Car convert(NewCarRequest request) {

        Optional<Driver> hasDriver = findDriverRepository.findDriverById(request.getDriversId());

        Driver driver = hasDriver.orElseThrow(() -> new DriverNotFoundException("The driver with id: " + request.getDriversId() + " wasn't found"));

        return new Car(UUID.randomUUID(),
                       driver,
                       new CarPlate(request.getPlateLetters(), request.getPlateNumbers(), request.getPlateState(), request.getPlateCity()),
                       request.getOdometer(),
                       request.getChasi(),
                       request.getType(),
                       request.getTransmission());
    }
}
