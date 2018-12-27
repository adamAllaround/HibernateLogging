package com.allaroundjava.service;

import com.allaroundjava.dao.Dao;
import com.allaroundjava.model.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class CarServiceImpl implements CarService {
    private static final Logger log = LogManager.getLogger(CarServiceImpl.class);
    private final Dao<Car> carDao;

    public CarServiceImpl(Dao<Car> carDao) {
        this.carDao = carDao;
    }

    @Override
    public Optional<Car> getById(Long id) {
        log.debug("Service request for object with id {}", id);
        return carDao.getById(id);
    }

    @Override
    public void persist(Car car) {
        log.debug("Service request to persist Car with make {}, model {}, manufactured {}",
                car.getMake(), car.getModel(), car.getManufacturedAt());
        carDao.persist(car);
    }
}
