package me.oyurimatheus.demoonionarchitecture.car.infra;

import me.oyurimatheus.demoonionarchitecture.car.domain.Driver;

public interface SaveDriverRepository {

    Driver save(Driver driver);
}
