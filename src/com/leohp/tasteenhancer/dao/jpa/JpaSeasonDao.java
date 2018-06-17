package com.leohp.tasteenhancer.dao.jpa;

import com.leohp.tasteenhancer.dao.SeasonDao;
import com.leohp.tasteenhancer.entity.Season;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
        Query query = em.createQuery("Select seasons from Season seasons where id=:id");
        query.setParameter("id", id);
        Season season = null;
        try {
            season = (Season) query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
        }

        return season;
    }

    @Override
    public List<Season> findAll() {
        List<Season> results = em.createQuery("SELECT s FROM Season s").getResultList();
        return results;
    }

    @Override
    public void update(Season object) {
        Season season = em.find(Season.class, object.getId());
        season.setName(object.getName());
        season.setIngredients(object.getIngredients());
        em.merge(season);
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