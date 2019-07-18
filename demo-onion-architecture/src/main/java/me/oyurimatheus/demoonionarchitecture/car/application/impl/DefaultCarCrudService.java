package me.oyurimatheus.demoonionarchitecture.car.application.impl;

import me.oyurimatheus.demoonionarchitecture.car.application.DeleteCar;
import me.oyurimatheus.demoonionarchitecture.car.application.FindCar;
import me.oyurimatheus.demoonionarchitecture.car.application.PersistCar;
import me.oyurimatheus.demoonionarchitecture.car.domain.Car;
import me.oyurimatheus.demoonionarchitecture.car.infra.DeleteCarRepository;
import me.oyurimatheus.demoonionarchitecture.car.infra.FindCarRepository;
import me.oyurimatheus.demoonionarchitecture.car.infra.SaveCarRepository;
import me.oyurimatheus.demoonionarchitecture.car.view.NewCarRequest;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
class DefaultCarCrudService implements PersistCar, FindCar, DeleteCar {

    private final FindCarRepository findCarRepository;
    private final SaveCarRepository saveCarRepository;
    private final DeleteCarRepository deleteCarRepository;
    private final Converter<NewCarRequest, Car> newCarRequestToCar;

    public DefaultCarCrudService(FindCarRepository findCarRepository, SaveCarRepository saveCarRepository, DeleteCarRepository deleteCarRepository, Converter<NewCarRequest, Car> newCarRequestToCar) {
        this.findCarRepository = findCarRepository;
        this.saveCarRepository = saveCarRepository;
        this.deleteCarRepository = deleteCarRepository;
        this.newCarRequestToCar = newCarRequestToCar;
    }

    @Override
    public Optional<Car> findById(UUID id) {
        return findCarRepository.findById(id);
    }

    @Override
    public Car save(NewCarRequest request) {
        Car car = newCarRequestToCar.convert(request);

        return saveCarRepository.save(car);
    }

    @Override
    public void deleteById(UUID id) {
        deleteCarRepository.deleteById(id);
    }
}
