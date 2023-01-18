package com.solvd.carservice.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class CarService {
    private long id;
    private String name;
    private BigDecimal price;
    private List<ServiceOrder> serviceOrders;

    public CarService() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        CarService that = (CarService) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(serviceOrders, that.serviceOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, serviceOrders);
    }

    @Override
    public String toString() {
        return "CarService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", serviceOrders=" + serviceOrders +
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
