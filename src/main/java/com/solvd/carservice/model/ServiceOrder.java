package com.solvd.carservice.model;

import com.solvd.carservice.enums.ServiceStatus;

import java.util.Date;
import java.util.Objects;

public class ServiceOrder {
    private long id;
    private long serviceStationId;
    private long carId;
    private long carServiceId;
    private long userId;
    private Date date;
    private ServiceStatus serviceStatus;

    public ServiceOrder() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        ServiceOrder that = (ServiceOrder) o;
        return id == that.id && serviceStationId == that.serviceStationId && carId == that.carId && carServiceId == that.carServiceId && userId == that.userId && Objects.equals(date, that.date) && serviceStatus == that.serviceStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceStationId, carId, carServiceId, userId, date, serviceStatus);
    }

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "id=" + id +
                ", serviceStationId=" + serviceStationId +
                ", carId=" + carId +
                ", carServiceId=" + carServiceId +
                ", userId=" + userId +
                ", date=" + date +
                ", serviceStatus=" + serviceStatus +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getServiceStationId() {
        return serviceStationId;
    }

    public void setServiceStationId(long serviceStationId) {
        this.serviceStationId = serviceStationId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getCarServiceId() {
        return carServiceId;
    }

    public void setCarServiceId(long carServiceId) {
        this.carServiceId = carServiceId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
}
