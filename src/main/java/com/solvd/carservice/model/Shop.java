package com.solvd.carservice.model;

import java.util.Objects;

public class Shop {
    private long id;
    private String name;
    private String address;
    private List<CarPart> carParts;
    private List<ShopOrder> shopOrders;

    public Shop() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        Shop shop = (Shop) o;
        return id == shop.id && Objects.equals(name, shop.name) && Objects.equals(address, shop.address) && Objects.equals(carParts, shop.carParts) && Objects.equals(shopOrders, shop.shopOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, carParts, shopOrders);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", carParts=" + carParts +
                ", shopOrders=" + shopOrders +
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

    public List<CarPart> getCarParts() {
        return carParts;
    }

    public void setCarParts(List<CarPart> carParts) {
        this.carParts = carParts;
    }

    public List<ShopOrder> getShopOrders() {
        return shopOrders;
    }

    public void setShopOrders(List<ShopOrder> shopOrders) {
        this.shopOrders = shopOrders;
    }
}
