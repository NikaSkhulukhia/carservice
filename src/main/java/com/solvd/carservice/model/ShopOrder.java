package com.solvd.carservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.solvd.carservice.enums.OrderStatus;

import java.util.Date;
import java.util.Objects;

public class ShopOrder {
    @JsonProperty("id")
    private long id;
    @JsonProperty("user_id")
    private long userId;
    @JsonProperty("shop_id")
    private long shopId;
    @JsonProperty("car_parts_id")
    private long carPartsId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("id")
    private Date date;
    @JsonProperty("order_status")
    private OrderStatus orderStatus;

    public ShopOrder() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.hashCode() != o.hashCode()) return false;
        ShopOrder shopOrder = (ShopOrder) o;
        return id == shopOrder.id && userId == shopOrder.userId && shopId == shopOrder.shopId && carPartsId == shopOrder.carPartsId && Objects.equals(date, shopOrder.date) && orderStatus == shopOrder.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, shopId, carPartsId, date, orderStatus);
    }

    @Override
    public String toString() {
        return "ShopOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", shopId=" + shopId +
                ", carPartsId=" + carPartsId +
                ", date=" + date +
                ", orderStatus=" + orderStatus +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getCarPartsId() {
        return carPartsId;
    }

    public void setCarPartsId(long carPartsId) {
        this.carPartsId = carPartsId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
