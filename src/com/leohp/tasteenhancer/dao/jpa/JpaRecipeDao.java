package com.leohp.tasteenhancer.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.leohp.tasteenhancer.dao.RecipeDao;
import com.leohp.tasteenhancer.entity.Recipe;

public class JpaRecipeDao implements RecipeDao {

    private EntityManagerFactory emf;

    public JpaRecipeDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }

    @Override
    public void create(Recipe object) {
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
    public Recipe findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Recipe recipe = em.find(Recipe.class, id);
        em.close();
        return recipe;
    }

    @Override
    public List<Recipe> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select recipes from Recipe recipes");
        List<Recipe> results = query.getResultList();
        em.close();
        return results;
    }

    @Override
    public void update(Recipe object) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("update Recipe rec set rec.name=:name, rec.ingredients=:ingredients where rec.id=:id");
        query.setParameter("name", object.getName());
        query.setParameter("id", object.getId());
        query.setParameter("ingredients", object.getIngredients());
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
            Recipe recipe = em.find(Recipe.class, id);
            em.remove(recipe);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }

    }

    @Override
    public void remove(Recipe object) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Recipe recipe = em.find(Recipe.class, object.getId());
            em.remove(recipe);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }
}
