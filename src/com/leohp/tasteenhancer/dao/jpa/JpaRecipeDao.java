package com.leohp.tasteenhancer.dao.jpa;

import com.leohp.tasteenhancer.dao.RecipeDao;
import com.leohp.tasteenhancer.entity.Recipe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
        Query query = em.createQuery("Select recipes from Recipe recipes where id=:id");
        query.setParameter("id", id);
        Recipe recipe = null;
        try {
            recipe = (Recipe) query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
        }

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
        Recipe recipe = em.find(Recipe.class, object.getId());
        recipe.setName(object.getName());
        recipe.setIngredients(object.getIngredients());
        em.merge(recipe);
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
