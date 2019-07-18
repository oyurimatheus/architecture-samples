package me.oyurimatheus.demoonionarchitecture.car.infra.impl;

import me.oyurimatheus.demoonionarchitecture.car.infra.CarEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface CarRepository extends CrudRepository<CarEntity, UUID> {
}
