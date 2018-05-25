package com.leohp.tasteenhancer.dao;

import com.leohp.tasteenhancer.dao.jpa.*;
import com.leohp.tasteenhancer.util.PersistenceManager;

public class DaoFactory {

    public static JpaIngredientDao getIngredientDao() {
        JpaIngredientDao jpaIngredientDao = new JpaIngredientDao(PersistenceManager.getEntityManagerFactory());
        return jpaIngredientDao;
    }

    public static JpaCategoryDao getCategoryDao() {
        JpaCategoryDao jpaCategoryDao = new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
        return jpaCategoryDao;
    }

    public static JpaOriginDao getOriginDao() {
        JpaOriginDao jpaOriginDao = new JpaOriginDao(PersistenceManager.getEntityManagerFactory());
        return jpaOriginDao;
    }

    public static JpaRecipeDao getRecipeDao() {
        JpaRecipeDao jpaRecipeDao = new JpaRecipeDao(PersistenceManager.getEntityManagerFactory());
        return jpaRecipeDao;
    }

    public static JpaSeasonDao getSeasonDao() {
        JpaSeasonDao jpaSeasonDao = new JpaSeasonDao(PersistenceManager.getEntityManagerFactory());
        return jpaSeasonDao;
    }

    public static JpaTasteDao getTasteDao() {
        JpaTasteDao jpaTasteDao = new JpaTasteDao(PersistenceManager.getEntityManagerFactory());
        return jpaTasteDao;
    }

}
