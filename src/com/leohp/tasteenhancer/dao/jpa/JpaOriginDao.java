package com.leohp.tasteenhancer.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.leohp.tasteenhancer.dao.OriginDao;
import com.leohp.tasteenhancer.entity.Origin;

public class JpaOriginDao implements OriginDao {

    private EntityManagerFactory emf;

    public JpaOriginDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }

    @Override
    public void create(Origin object) {
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
    public Origin findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Origin origin = em.find(Origin.class, id);
        em.close();
        return origin;
    }

    @Override
    public List<Origin> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select origins from Origin origins");
        List<Origin> results = query.getResultList();
        em.close();
        return results;
    }

    @Override
    public void update(Origin object) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("update Origin ori set ori.name=:name, ori.ingredients=:ingredients where ori.id=:id");
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
            Origin origin = em.find(Origin.class, id);
            em.remove(origin);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }

    }

    @Override
    public void remove(Origin object) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Origin origin = em.find(Origin.class, object.getId());
            em.remove(origin);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }
}
