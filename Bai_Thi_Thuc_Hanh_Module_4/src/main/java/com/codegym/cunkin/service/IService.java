package com.codegym.cunkin.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface IService<T> {

    Iterable<T> findAll();

    Page<T> findAll(int pageNumber);

    T findById(Long id);

    void save(T model);

    void remove(Long id);
}
