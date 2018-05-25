package com.leohp.tasteenhancer.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.leohp.tasteenhancer.dao.SeasonDao;
import com.leohp.tasteenhancer.entity.Season;

public class JpaSeasonDao implements SeasonDao {

    private EntityManagerFactory emf;

    public JpaSeasonDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }

    @Override
    public void create(Season object) {
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
    public Season findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Season season = em.find(Season.class, id);
        em.close();
        return season;
    }

    @Override
    public List<Season> findAll() {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("Select seasons from Season seasons");
        List<Season> results = query.getResultList();
        em.close();
        return results;
    }

    @Override
    public void update(Season object) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("update Season sea set sea.name=:name, sea.ingredients=:ingredients where sea.id=:id");
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
            Season season = em.find(Season.class, id);
            em.remove(season);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }

    }

    @Override
    public void remove(Season object) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Season season = em.find(Season.class, object.getId());
            em.remove(season);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
        }
    }
}