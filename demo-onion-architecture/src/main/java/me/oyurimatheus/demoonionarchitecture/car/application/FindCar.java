package me.oyurimatheus.demoonionarchitecture.car.application;

import me.oyurimatheus.demoonionarchitecture.car.domain.Car;

import java.util.Optional;
import java.util.UUID;

public interface FindCar {

    Optional<Car> findById(UUID id);
}
