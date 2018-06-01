package com.leohp.tasteenhancer.dao;

import java.util.List;

public interface GenericDao<T> {

    void create(T object);

    T findById(Long id);

    List<T> findAll();

    void update(T object);

    void remove(Long id);

    void remove(T object);

}
