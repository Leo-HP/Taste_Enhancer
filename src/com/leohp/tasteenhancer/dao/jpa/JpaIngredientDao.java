package com.leohp.tasteenhancer.dao.jpa;

import com.leohp.tasteenhancer.dao.IngredientDao;
import com.leohp.tasteenhancer.entity.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class JpaIngredientDao implements IngredientDao {

    @PersistenceContext(name = "PU")
    private EntityManager entityManager;

    @Override
    public void create(Ingredient object) {
        List<Category> categories = new ArrayList<>();
        for (Category category : object.getCategories()) {
            categories.add(entityManager.find(Category.class, category.getId()));
        }
        List<Origin> origins = new ArrayList<>();
        for (Origin origin : object.getOrigins()) {
            origins.add(entityManager.find(Origin.class, origin.getId()));
        }
        List<Season> seasons = new ArrayList<>();
        for (Season season : object.getSeasons()) {
            seasons.add(entityManager.find(Season.class, season.getId()));
        }
        List<Taste> tastes = new ArrayList<>();
        for (Taste taste : object.getTastes()) {
            tastes.add(entityManager.find(Taste.class, taste.getId()));
        }
        entityManager.persist(object);
    }

    @Override
    public Ingredient findById(Long id) {
        Ingredient ingredient = entityManager.find(Ingredient.class, id);
        return ingredient;
    }

    @Override
    public List<Ingredient> findAll() {
        Query query = entityManager.createQuery("Select indredients from Ingredient indredients");
        List<Ingredient> results = query.getResultList();
        return results;
    }

    @Override
    public void update(Ingredient object) {
        Ingredient ingredient = entityManager.find(Ingredient.class, object.getId());
        ingredient.setName(object.getName());
        ingredient.setOrigins(object.getOrigins());
        ingredient.setCategories(object.getCategories());
        ingredient.setSeasons(object.getSeasons());
        ingredient.setTastes(object.getTastes());
        entityManager.merge(ingredient);
    }

    @Override
    public void remove(Long id) {
        Ingredient ingredient = entityManager.find(Ingredient.class, id);
        entityManager.remove(ingredient);
    }

    @Override
    public void remove(Ingredient object) {
        Ingredient ingredient = entityManager.find(Ingredient.class, object.getId());
        entityManager.remove(ingredient);

    }
}
