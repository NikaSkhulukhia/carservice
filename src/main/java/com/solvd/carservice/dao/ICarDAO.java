package com.solvd.carservice.dao;

import com.solvd.carservice.model.Car;

import java.util.List;

public interface ICarDAO extends IBaseDAO{
    List<Car> getAllCars();
    Car getCarByUserId(long userId);
}
