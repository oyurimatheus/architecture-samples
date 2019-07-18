package me.oyurimatheus.demoonionarchitecture.car.view;

import me.oyurimatheus.demoonionarchitecture.car.application.DeleteCar;
import me.oyurimatheus.demoonionarchitecture.car.application.FindCar;
import me.oyurimatheus.demoonionarchitecture.car.application.PersistCar;
import me.oyurimatheus.demoonionarchitecture.car.domain.Car;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.text.MessageFormat;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
class CarController {

    private final PersistCar persistCar;
    private final FindCar findCar;
    private final DeleteCar deleteCar;
    private final Converter<Car, CarResponse> carToCarResponse;

    CarController(PersistCar persistCar, FindCar findCar, DeleteCar deleteCar, Converter<Car, CarResponse> carToCarResponse) {
        this.persistCar = persistCar;
        this.findCar = findCar;
        this.deleteCar = deleteCar;
        this.carToCarResponse = carToCarResponse;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> findCarById(@PathVariable("id")UUID id) {
        Optional<Car> car = findCar.findById(id);

        if(car.isEmpty())
            return ResponseEntity.notFound().build();

        CarResponse carResponse = carToCarResponse.convert(car.get());

        return ResponseEntity.ok(carResponse);
    }

    @PostMapping
    public ResponseEntity<CarResponse> createCar(NewCarRequest request) {
        Car car = persistCar.save(request);

        CarResponse response = carToCarResponse.convert(car);
        URI location = URI.create(MessageFormat.format("/cars/{0}", response.getId()));

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CarResponse> deleteCar(@PathVariable("id") UUID id) {
        deleteCar.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
