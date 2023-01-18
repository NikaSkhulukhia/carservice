package com.solvd.carservice.model;

import java.util.List;
import java.util.Objects;

public class ServiceStation {
    private long id;
    private String name;
    private String address;
    private List<ServiceOrder> serviceOrders;

    public ServiceStation() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        ServiceStation that = (ServiceStation) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(serviceOrders, that.serviceOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, serviceOrders);
    }

    @Override
    public String toString() {
        return "ServiceStation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }
}
