package com.solvd.carservice.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String phone;
    private String email;
    private String address;
    private Date memberSince;
    private List<Car> cars;
    private List<ServiceOrder> serviceOrders;
    private List<ShopOrder> shopOrders;

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName)
                && Objects.equals(idNumber, user.idNumber) && Objects.equals(phone, user.phone)
                && Objects.equals(email, user.email) && Objects.equals(address, user.address)
                && Objects.equals(memberSince, user.memberSince) && Objects.equals(cars, user.cars)
                && Objects.equals(serviceOrders, user.serviceOrders) && Objects.equals(shopOrders, user.shopOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, idNumber, phone, email, address, memberSince, cars, serviceOrders, shopOrders);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", memberSince=" + memberSince +
                ", cars=" + cars +
                ", serviceOrders=" + serviceOrders +
                ", shopOrders=" + shopOrders +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<ServiceOrder> getServiceOrders() {
        return serviceOrders;
    }

    public void setServiceOrders(List<ServiceOrder> serviceOrders) {
        this.serviceOrders = serviceOrders;
    }

    public List<ShopOrder> getShopOrders() {
        return shopOrders;
    }

    public void setShopOrders(List<ShopOrder> shopOrders) {
        this.shopOrders = shopOrders;
    }
}

