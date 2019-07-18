package me.oyurimatheus.demoonionarchitecture.car.application;

import me.oyurimatheus.demoonionarchitecture.car.domain.Car;
import me.oyurimatheus.demoonionarchitecture.car.view.NewCarRequest;

public interface PersistCar {

    Car save(NewCarRequest request);
}
