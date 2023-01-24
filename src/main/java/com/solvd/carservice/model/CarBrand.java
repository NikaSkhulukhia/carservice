package com.solvd.carservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carservice.enums.Country;

import java.util.List;
import java.util.Objects;

public class CarBrand {
    @JsonProperty("id")
    private long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("country_of_origin")
    private Country countryOfOrigin;
    @JsonProperty("carBrandModels")
    private List<CarBrandModel> carBrandModels;
    @JsonProperty("cars")
    private List<Car> cars;

    public CarBrand() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        CarBrand carBrand = (CarBrand) o;
        return id == carBrand.id && Objects.equals(name, carBrand.name) && countryOfOrigin == carBrand.countryOfOrigin && Objects.equals(carBrandModels, carBrand.carBrandModels) && Objects.equals(cars, carBrand.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryOfOrigin, carBrandModels, cars);
    }

    @Override
    public String toString() {
        return "CarBrand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryOfOrigin=" + countryOfOrigin +
                ", carBrandModels=" + carBrandModels +
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

    public Country getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(Country countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public List<CarBrandModel> getCarBrandModels() {
        return carBrandModels;
    }

    public void setCarBrandModels(List<CarBrandModel> carBrandModels) {
        this.carBrandModels = carBrandModels;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
