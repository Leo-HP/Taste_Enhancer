package com.leohp.tasteenhancer.dao.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import com.leohp.tasteenhancer.dao.IngredientDao;
import com.leohp.tasteenhancer.entity.Ingredient;

@Stateless
public class JpaIngredientDao implements IngredientDao {

    @PersistenceContext(name="PU")
    private EntityManager entityManager;

    @Override
    public void create(Ingredient object) {
        entityManager.persist(object);
    }

    @Override
    public Ingredient findById(Long id) {
        Ingredient ingredient = entityManager.find(Ingredient.class, id);
        return ingredient;
    }

    @Override
    public List<Ingredient> findAll() {
        Query query = entityManager.createQuery("Select ingredients from Ingredient indredients");
        List<Ingredient> results = query.getResultList();
        return results;
    }

    @Override
    public void update(Ingredient object) {
        Query query = entityManager.createQuery("update Ingredient ing set ing.name=:name, ing.categories=:categories, ing.origins=:origins, ing.seasons=:seasons, ing.tastes=:tastes, ing.recipes=:recipes where ing.id=:id");
        query.setParameter("name", object.getName());
        query.setParameter("id", object.getId());
        query.setParameter("categories", object.getCategories());
        query.setParameter("origins", object.getOrigins());
        query.setParameter("seasons", object.getSeasons());
        query.setParameter("tastes", object.getTastes());
        query.setParameter("recipes", object.getRecipes());
        query.executeUpdate();
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
