package me.oyurimatheus.demoonionarchitecture.car.infra;

import java.util.UUID;

public interface DeleteCarRepository {
    void deleteById(UUID id);
}
