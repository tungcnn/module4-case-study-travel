package com.travel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneral<T> {
    Page<T> findAll(Pageable pageable);
    T findById(long id);
    void save(T t);
    void delete(long id);
}
