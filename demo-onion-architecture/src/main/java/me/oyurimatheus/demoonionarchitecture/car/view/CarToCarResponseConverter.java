package me.oyurimatheus.demoonionarchitecture.car.view;

import me.oyurimatheus.demoonionarchitecture.car.domain.Car;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
class CarToCarResponseConverter implements Converter<Car, CarResponse> {
    @Override
    public CarResponse convert(Car car) {
        return new CarResponse(car.getId(), car.getDriver(),
                               car.getPlate(),
                               car.getTransmission(),
                               car.getType(),
                               car.getChasi(),
                               car.getOdometer());
    }
}
