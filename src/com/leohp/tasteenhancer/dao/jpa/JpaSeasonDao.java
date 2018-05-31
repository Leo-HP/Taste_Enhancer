package com.leohp.tasteenhancer.dao.jpa;

import com.leohp.tasteenhancer.dao.SeasonDao;
import com.leohp.tasteenhancer.entity.Season;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class JpaSeasonDao implements SeasonDao {

    @PersistenceContext(name = "PU")
    private EntityManager em;

    @Override
    public void create(Season object) {
        em.persist(object);
    }

    @Override
    public Season findById(Long id) {
        Season season = em.find(Season.class, id);
        return season;
    }

    @Override
    public List<Season> findAll() {
        List<Season> results = em.createQuery("SELECT s FROM Season s").getResultList();
        return results;
    }

    @Override
    public void update(Season object) {
        Query query = em.createQuery("update Season sea set sea.name=:name, sea.ingredients=:ingredients where sea.id=:id");
        query.setParameter("name", object.getName());
        query.setParameter("id", object.getId());
        query.setParameter("ingredients", object.getIngredients());
        query.executeUpdate();
    }

    @Override
    public void remove(Long id) {
        Season season = em.find(Season.class, id);
        em.remove(season);
    }

    @Override
    public void remove(Season object) {
        Season season = em.find(Season.class, object.getId());
        em.remove(season);
    }
}