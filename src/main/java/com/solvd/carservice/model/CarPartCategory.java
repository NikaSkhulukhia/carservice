package com.solvd.carservice.model;

import java.util.List;
import java.util.Objects;

public class CarPartCategory {
    private long id;
    private String name;
    private List<CarPart> carParts;

    public CarPartCategory() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        CarPartCategory that = (CarPartCategory) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(carParts, that.carParts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, carParts);
    }

    @Override
    public String toString() {
        return "CarPartCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", carParts=" + carParts +
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

    public List<CarPart> getCarParts() {
        return carParts;
    }

    public void setCarParts(List<CarPart> carParts) {
        this.carParts = carParts;
    }
}
