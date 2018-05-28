package com.leohp.tasteenhancer.dao.jpa;

import com.leohp.tasteenhancer.dao.TasteDao;
import com.leohp.tasteenhancer.entity.Taste;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class JpaTasteDao implements TasteDao {

    @PersistenceContext(name = "PU")
    private EntityManager em;

    @Override
    public void create(Taste object) {
        em.persist(object);
    }

    @Override
    public Taste findById(Long id) {
        Taste taste = em.find(Taste.class, id);
        return taste;
    }

    @Override
    public List<Taste> findAll() {
        Query query = em.createQuery("Select tastes from Taste tastes");
        List<Taste> results = query.getResultList();
        return results;
    }

    @Override
    public void update(Taste object) {
        Query query = em.createQuery("update Taste taste set taste.name=:name, taste.ingredients=:ingredients where taste.id=:id");
        query.setParameter("name", object.getName());
        query.setParameter("id", object.getId());
        query.setParameter("ingredients", object.getIngredients());
        query.executeUpdate();
    }

    @Override
    public void remove(Long id) {
        Taste taste = em.find(Taste.class, id);
        em.remove(taste);
    }

    @Override
    public void remove(Taste object) {
        Taste taste = em.find(Taste.class, object.getId());
        em.remove(taste);
    }
}

