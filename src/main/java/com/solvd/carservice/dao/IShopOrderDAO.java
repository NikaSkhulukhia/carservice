package com.solvd.carservice.dao;

import com.solvd.carservice.model.ShopOrder;

import java.util.List;

public interface IShopOrderDAO extends IBaseDAO{
    List<ShopOrder> getShopOrdersByUserId(long id);
}
