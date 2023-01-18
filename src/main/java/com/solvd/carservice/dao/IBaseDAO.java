package com.solvd.carservice.dao;

public interface IBaseDAO<T> {
    public T getEntityById(long id);
    public T createEntity(T entity);
    public T updateEntity(T entity);
    public void removeEntity(T entity);
}
