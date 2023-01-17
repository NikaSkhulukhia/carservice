package com.solvd.carservice.model;

import java.math.BigDecimal;
import java.util.Objects;

public class CarPart {
    private long id;
    private String name;
    private String serialNumber;
    private BigDecimal price;
    private long carPartCategoryId;
    private long shopId;

    public CarPart() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        CarPart carPart = (CarPart) o;
        return id == carPart.id && carPartCategoryId == carPart.carPartCategoryId && shopId == carPart.shopId && Objects.equals(name, carPart.name) && Objects.equals(serialNumber, carPart.serialNumber) && Objects.equals(price, carPart.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, serialNumber, price, carPartCategoryId, shopId);
    }

    @Override
    public String toString() {
        return "CarPart{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", price=" + price +
                ", carPartCategoryId=" + carPartCategoryId +
                ", shopId=" + shopId +
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getCarPartCategoryId() {
        return carPartCategoryId;
    }

    public void setCarPartCategoryId(long carPartCategoryId) {
        this.carPartCategoryId = carPartCategoryId;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }
}
