package com.allaroundjava.dao;

import com.allaroundjava.model.Car;

import javax.persistence.EntityManagerFactory;

public class CarDao extends BaseDao<Car> {

    public CarDao(EntityManagerFactory emf) {
        super(Car.class, emf);
    }
}
