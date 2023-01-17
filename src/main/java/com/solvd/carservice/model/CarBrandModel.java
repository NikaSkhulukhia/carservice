package com.solvd.carservice.model;

import com.solvd.carservice.enums.FuelType;
import com.solvd.carservice.enums.Transmission;

import java.util.List;
import java.util.Objects;

public class CarBrandModel {
    private long id;
    private String name;
    private long carBrandId;
    private FuelType fuelType;
    private Transmission transmission;
    private List<Car> cars;

    public CarBrandModel() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        CarBrandModel that = (CarBrandModel) o;
        return id == that.id && carBrandId == that.carBrandId && Objects.equals(name, that.name) && fuelType == that.fuelType && transmission == that.transmission && Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, carBrandId, fuelType, transmission, cars);
    }

    @Override
    public String toString() {
        return "CarBrandModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", carBrandId=" + carBrandId +
                ", fuelType=" + fuelType +
                ", transmission=" + transmission +
                ", cars=" + cars +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(long carBrandId) {
        this.carBrandId = carBrandId;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
