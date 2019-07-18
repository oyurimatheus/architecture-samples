package me.oyurimatheus.demoonionarchitecture;

import me.oyurimatheus.demoonionarchitecture.car.application.PersistCar;
import me.oyurimatheus.demoonionarchitecture.car.application.PersistDriver;
import me.oyurimatheus.demoonionarchitecture.car.domain.CarTransmission;
import me.oyurimatheus.demoonionarchitecture.car.domain.CarType;
import me.oyurimatheus.demoonionarchitecture.car.domain.Driver;
import me.oyurimatheus.demoonionarchitecture.car.view.NewCarRequest;
import org.h2.command.Command;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class DemoOnionArchitectureApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoOnionArchitectureApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(PersistCar persistCar, PersistDriver persistDriver) {
		UUID driverId = UUID.randomUUID();

		Driver driver = new Driver(driverId, "Raul Seixar", "Maluco Beleza");



		NewCarRequest request = new NewCarRequest(driverId,
				"FYE",
				"7949",
				"SP", "São Paulo", 1000, "adsf", CarType.HATCH, CarTransmission.MANUAL);
		return (args) -> {
			persistDriver.save(driver);
			persistCar.save(request);
		};
	}
}
