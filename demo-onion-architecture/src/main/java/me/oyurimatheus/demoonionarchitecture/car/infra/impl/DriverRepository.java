package me.oyurimatheus.demoonionarchitecture.car.infra.impl;

import me.oyurimatheus.demoonionarchitecture.car.infra.DriverEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

interface DriverRepository extends CrudRepository<DriverEntity, UUID> {
}
