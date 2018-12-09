package com.allaroundjava.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@org.hibernate.annotations.Immutable
public final class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String make;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false, name = "manufactured_at")
    private LocalDate manufacturedAt;

    private Car() {
    }

    private Car(String make, String model, LocalDate manufacturedAt) {
        this.make = make;
        this.model = model;
        this.manufacturedAt = manufacturedAt;
    }

    public Car newInstance(String make, String model, LocalDate manufacturedAt) {
        return new Car(make, model, manufacturedAt);
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getManufacturedAt() {
        return manufacturedAt;
    }
}
