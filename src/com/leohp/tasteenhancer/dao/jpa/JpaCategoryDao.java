package com.leohp.tasteenhancer.dao.jpa;

import com.leohp.tasteenhancer.dao.CategoryDao;
import com.leohp.tasteenhancer.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class JpaCategoryDao implements CategoryDao {

    private EntityManagerFactory emf;

    public JpaCategoryDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }

    @Override
    public void create(Category object) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(object);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }

    }

    @Override
    public Category findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Category category = em.find(Category.class, id);
        em.close();
        return category;
    }

    @Override
    public List<Category> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select categories from Category categories");
        List<Category> results = query.getResultList();
        em.close();
        return results;
    }

    @Override
    public void update(Category object) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("update Category cat set cat.name=:name, cat.ingredients=:ingredients where cat.id=:id");
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
            Category category = em.find(Category.class, id);
            em.remove(category);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }

    }

    @Override
    public void remove(Category object) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Category category = em.find(Category.class, object.getId());
            em.remove(category);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }
}
