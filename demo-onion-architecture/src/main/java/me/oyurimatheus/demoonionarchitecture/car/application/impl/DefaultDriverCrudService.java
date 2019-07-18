package me.oyurimatheus.demoonionarchitecture.car.application.impl;

import me.oyurimatheus.demoonionarchitecture.car.application.PersistDriver;
import me.oyurimatheus.demoonionarchitecture.car.domain.Driver;
import me.oyurimatheus.demoonionarchitecture.car.infra.SaveDriverRepository;
import org.springframework.stereotype.Component;

@Component
class DefaultDriverCrudService implements PersistDriver {

    private final SaveDriverRepository saveDriverRepository;

    DefaultDriverCrudService(SaveDriverRepository saveDriverRepository) {
        this.saveDriverRepository = saveDriverRepository;
    }

    @Override
    public Driver save(Driver driver) {
        return saveDriverRepository.save(driver);
    }
}
