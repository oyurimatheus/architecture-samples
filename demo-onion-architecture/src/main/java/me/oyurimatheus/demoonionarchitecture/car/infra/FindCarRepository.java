package me.oyurimatheus.demoonionarchitecture.car.infra;

import me.oyurimatheus.demoonionarchitecture.car.domain.Car;

import java.util.Optional;
import java.util.UUID;

public interface FindCarRepository {

    Optional<Car> findById(UUID id);
}
