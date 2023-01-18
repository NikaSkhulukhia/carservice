package com.solvd.carservice.model;

import com.solvd.carservice.enums.Color;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Car {
    private long id;
    private Date year;
    private long userId;
    private long carBrandId;
    private long brandModelId;
    private String licensePlate;
    private String currentMileage;
    private Color color;
    private List<ServiceOrder> serviceOrders;

    public Car() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Car car = (Car) o;
        return id == car.id && userId == car.userId && carBrandId == car.carBrandId && brandModelId == car.brandModelId && Objects.equals(year, car.year) && Objects.equals(licensePlate, car.licensePlate) && Objects.equals(currentMileage, car.currentMileage) && color == car.color && Objects.equals(serviceOrders, car.serviceOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, userId, carBrandId, brandModelId, licensePlate, currentMileage, color, serviceOrders);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", year=" + year +
                ", userId=" + userId +
                ", carBrandId=" + carBrandId +
                ", brandModelId=" + brandModelId +
                ", licensePlate='" + licensePlate + '\'' +
                ", currentMileage='" + currentMileage + '\'' +
                ", color=" + color +
                ", serviceOrders=" + serviceOrders +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(long carBrandId) {
        this.carBrandId = carBrandId;
    }

    public long getBrandModelId() {
        return brandModelId;
    }

    public void setBrandModelId(long brandModelId) {
        this.brandModelId = brandModelId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(String currentMileage) {
        this.currentMileage = currentMileage;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
