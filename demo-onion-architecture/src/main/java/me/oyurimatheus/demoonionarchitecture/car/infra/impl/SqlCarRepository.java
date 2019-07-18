package me.oyurimatheus.demoonionarchitecture.car.infra.impl;

import me.oyurimatheus.demoonionarchitecture.car.domain.Car;
import me.oyurimatheus.demoonionarchitecture.car.infra.CarEntity;
import me.oyurimatheus.demoonionarchitecture.car.infra.DeleteCarRepository;
import me.oyurimatheus.demoonionarchitecture.car.infra.FindCarRepository;
import me.oyurimatheus.demoonionarchitecture.car.infra.SaveCarRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
class SqlCarRepository implements SaveCarRepository, FindCarRepository, DeleteCarRepository {

    private final CarRepository carRepository;
    private final Converter<CarEntity, Car> carEntityToCar;
    private final Converter<Car, CarEntity> carToCarEntity;

    SqlCarRepository(CarRepository carRepository, Converter<CarEntity, Car> carEntityToCar, Converter<Car, CarEntity> carToCarEntity) {
        this.carRepository = carRepository;
        this.carEntityToCar = carEntityToCar;
        this.carToCarEntity = carToCarEntity;
    }

    @Override
    public Optional<Car> findById(UUID id) {
        Optional<CarEntity> car = carRepository.findById(id);

        if(car.isEmpty())
            return Optional.empty();

        CarEntity carEntity = car.get();

        return Optional.of(carEntityToCar.convert(carEntity));
    }

    @Override
    public Car save(Car car) {
        CarEntity entity = carToCarEntity.convert(car);

        CarEntity saved = carRepository.save(entity);
        return carEntityToCar.convert(saved);
    }

    @Override
    public void deleteById(UUID id) {
        carRepository.deleteById(id);
    }
}
