package com.travel.service;

public interface IGeneral<T> {
    Iterable<T> findAll();
    T findById(long id);
    void save(T t);
    void delete(long id);
}
