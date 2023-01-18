package com.solvd.carservice.model;

import com.solvd.carservice.enums.ServiceStatus;

import java.util.Date;
import java.util.Objects;

public class ServiceOrder {
    private long id;
    private ServiceStation serviceStation;
    private Car car;
    private CarService carService;
    private Date date;
    private User user;
    private ServiceStatus serviceStatus;

    public ServiceOrder() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        ServiceOrder that = (ServiceOrder) o;
        return id == that.id && Objects.equals(serviceStation, that.serviceStation) && Objects.equals(car, that.car) && Objects.equals(carService, that.carService) && Objects.equals(date, that.date) && Objects.equals(user, that.user) && serviceStatus == that.serviceStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceStation, car, carService, date, user, serviceStatus);
    }

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "id=" + id +
                ", serviceStation=" + serviceStation +
                ", car=" + car +
                ", carService=" + carService +
                ", date=" + date +
                ", user=" + user +
                ", serviceStatus=" + serviceStatus +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ServiceStation getServiceStation() {
        return serviceStation;
    }

    public void setServiceStation(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarService getCarService() {
        return carService;
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
}
