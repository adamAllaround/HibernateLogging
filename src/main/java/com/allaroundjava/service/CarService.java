package com.allaroundjava.service;

import com.allaroundjava.model.Car;

import java.util.Optional;

public interface CarService {
    Optional<Car> getById(Long id);

    void persist(Car transaction);
}
