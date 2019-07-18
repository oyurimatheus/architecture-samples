package me.oyurimatheus.demoonionarchitecture.car.infra;

import me.oyurimatheus.demoonionarchitecture.car.domain.Driver;

import java.util.Optional;
import java.util.UUID;

public interface FindDriverRepository {

    Optional<Driver> findDriverById(UUID id);
}
