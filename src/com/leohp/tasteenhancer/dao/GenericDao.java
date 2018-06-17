package com.leohp.tasteenhancer.dao;

import java.util.List;
/*
** Genric DAO interface defining the methods common to all DAO classes
 */
public interface GenericDao<T> {

    void create(T object);

    T findById(Long id);

    List<T> findAll();

    void update(T object);

    void remove(Long id);

    void remove(T object);

}
