package com.leohp.tasteenhancer.dao.jpa;

import com.leohp.tasteenhancer.dao.RecipeDao;
import com.leohp.tasteenhancer.entity.Recipe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class JpaRecipeDao implements RecipeDao {

    @PersistenceContext(name = "PU")
    private EntityManager em;

    @Override
    public void create(Recipe object) {
        em.persist(object);
    }

    @Override
    public Recipe findById(Long id) {
        Recipe recipe = em.find(Recipe.class, id);
        return recipe;
    }

    @Override
    public List<Recipe> findAll() {
        Query query = em.createQuery("Select recipes from Recipe recipes");
        List<Recipe> results = query.getResultList();
        return results;
    }

    @Override
    public void update(Recipe object) {
        Query query = em.createQuery("update Recipe rec set rec.name=:name, rec.ingredients=:ingredients where rec.id=:id");
        query.setParameter("name", object.getName());
        query.setParameter("id", object.getId());
        query.setParameter("ingredients", object.getIngredients());
        query.executeUpdate();
    }

    @Override
    public void remove(Long id) {
        Recipe recipe = em.find(Recipe.class, id);
        em.remove(recipe);
    }

    @Override
    public void remove(Recipe object) {
        Recipe recipe = em.find(Recipe.class, object.getId());
        em.remove(recipe);
    }
}
