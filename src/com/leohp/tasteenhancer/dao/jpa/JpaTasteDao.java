package com.leohp.tasteenhancer.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.leohp.tasteenhancer.dao.TasteDao;
import com.leohp.tasteenhancer.entity.Taste;

public class JpaTasteDao implements TasteDao {

    private EntityManagerFactory emf;

    public JpaTasteDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }

    @Override
    public void create(Taste object) {
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
    public Taste findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Taste taste = em.find(Taste.class, id);
        em.close();
        return taste;
    }

    @Override
    public List<Taste> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select tastes from Taste tastes");
        List<Taste> results = query.getResultList();
        em.close();
        return results;
    }

    @Override
    public void update(Taste object) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("update Taste taste set taste.name=:name, taste.ingredients=:ingredients where taste.id=:id");
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
            Taste taste = em.find(Taste.class, id);
            em.remove(taste);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }

    }

    @Override
    public void remove(Taste object) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Taste taste = em.find(Taste.class, object.getId());
            em.remove(taste);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }
}

