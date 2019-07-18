package me.oyurimatheus.demoonionarchitecture.car.infra;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Table(name = "drivers")
@Entity
public class DriverEntity {

    @Id
    private UUID id;
    private String name;
    private String driversLicense;

    /**
     * @deprecated frameworks eyes only
     */
    private DriverEntity() { }

    public DriverEntity(UUID id, String name, String driversLicense) {
        this.id = id;
        this.name = name;
        this.driversLicense = driversLicense;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDriversLicense() {
        return driversLicense;
    }
}
