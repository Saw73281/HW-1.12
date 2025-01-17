package org.example.model;

import javax.persistence.*;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @Column(name = "planet_id", nullable = false, length = 10)
    @Pattern(regexp = "^[A-Z0-9]+$", message = "ID must contain only uppercase Latin letters and digits")
    private String planetId;

    @Column(name = "planet_name", nullable = false, length = 500)
    private String planetName;

    public Planet() {}

    public Planet(String planetId, String planetName) {
        this.planetId = planetId;
        this.planetName = planetName;
    }

    public String getPlanetId() {
        return planetId;
    }

    public void setPlanetId(String planetId) {
        this.planetId = planetId;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }
}
