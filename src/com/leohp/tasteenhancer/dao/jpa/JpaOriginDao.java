package com.leohp.tasteenhancer.dao.jpa;

import com.leohp.tasteenhancer.dao.OriginDao;
import com.leohp.tasteenhancer.entity.Origin;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class JpaOriginDao implements OriginDao {

    @PersistenceContext(name = "PU")
    private EntityManager em;

    @Override
    public void create(Origin object) {
        em.persist(object);

    }

    @Override
    public Origin findById(Long id) {
        Origin origin = em.find(Origin.class, id);
        return origin;
    }

    @Override
    public List<Origin> findAll() {
        Query query = em.createQuery("Select origins from Origin origins");
        List<Origin> results = query.getResultList();
        return results;
    }

    @Override
    public void update(Origin object) {
        Origin origin = em.find(Origin.class, object.getId());
        origin.setName(object.getName());
        origin.setIngredients((object.getIngredients()));
        em.merge(origin);
    }

    @Override
    public void remove(Long id) {
        Origin origin = em.find(Origin.class, id);
        em.remove(origin);
    }

    @Override
    public void remove(Origin object) {
        Origin origin = em.find(Origin.class, object.getId());
        em.remove(origin);
    }
}
