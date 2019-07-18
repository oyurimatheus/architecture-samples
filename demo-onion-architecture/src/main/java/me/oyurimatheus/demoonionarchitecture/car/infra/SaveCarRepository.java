package me.oyurimatheus.demoonionarchitecture.car.infra;

import me.oyurimatheus.demoonionarchitecture.car.domain.Car;

public interface SaveCarRepository {
    Car save(Car car);

}
