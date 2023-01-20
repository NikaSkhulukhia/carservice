package com.solvd.carservice.dao;

import com.solvd.carservice.model.ServiceOrder;

import java.util.List;

public interface IServiceOrderDAO extends IBaseDAO{
    List<ServiceOrder> getServiceOrdersByUserId(long id);
}
