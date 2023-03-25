package com.orderservice.orderservice.services;

import java.util.List;

public interface CustomService<T> {
    public List<T> getAll();

    public T getById(long id);

    public void saveOrUpdate(T elem);

    public void delete(long id);
}
