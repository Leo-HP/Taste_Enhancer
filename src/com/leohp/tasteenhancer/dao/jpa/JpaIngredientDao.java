package com.leohp.tasteenhancer.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.leohp.tasteenhancer.dao.IngredientDao;
import com.leohp.tasteenhancer.entity.Ingredient;

public class JpaIngredientDao implements IngredientDao {

    private EntityManagerFactory emf;

    public JpaIngredientDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }

    @Override
    public void create(Ingredient object) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(object);
            et.commit();
        }finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }

    @Override
    public Ingredient findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Ingredient ingredient = em.find(Ingredient.class, id);
        em.close();
        return ingredient;
    }

    @Override
    public List<Ingredient> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select ingredients from Ingredient indredients");
        List<Ingredient> results = query.getResultList();
        em.close();
        return results;
    }

    @Override
    public void update(Ingredient object) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("update Ingredient ing set ing.name=:name, ing.categories=:categories, ing.origins=:origins, ing.seasons=:seasons, ing.tastes=:tastes, ing.recipes=:recipes where ing.id=:id");
        query.setParameter("name", object.getName());
        query.setParameter("id", object.getId());
        query.setParameter("categories", object.getCategories());
        query.setParameter("origins", object.getOrigins());
        query.setParameter("seasons", object.getSeasons());
        query.setParameter("tastes", object.getTastes());
        query.setParameter("recipes", object.getRecipes());
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            query.executeUpdate();
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }

    }

    @Override
    public void remove(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Ingredient ingredient = em.find(Ingredient.class, id);
            em.remove(ingredient);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }

    }

    @Override
    public void remove(Ingredient object) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Ingredient ingredient = em.find(Ingredient.class, object.getId());
            em.remove(ingredient);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }
}
