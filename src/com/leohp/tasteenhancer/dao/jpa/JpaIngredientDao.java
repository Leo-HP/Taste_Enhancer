package com.leohp.tasteenhancer.dao.jpa;

import com.leohp.tasteenhancer.dao.IngredientDao;
import com.leohp.tasteenhancer.entity.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Stateless
public class JpaIngredientDao implements IngredientDao {

    @PersistenceContext(name = "PU")
    private EntityManager entityManager;

    @Override
    public void create(Ingredient object) {
        List<Category> categories = new ArrayList<>();
        if (object.getCategories() != null) {
            for (Category category : object.getCategories()) {
                categories.add(entityManager.find(Category.class, category.getId()));
            }
        }
        List<Origin> origins = new ArrayList<>();
        if (object.getOrigins() != null) {
            for (Origin origin : object.getOrigins()) {
                origins.add(entityManager.find(Origin.class, origin.getId()));
            }
        }
        List<Season> seasons = new ArrayList<>();
        if (object.getSeasons() != null) {
            for (Season season : object.getSeasons()) {
                seasons.add(entityManager.find(Season.class, season.getId()));
            }
        }
        List<Taste> tastes = new ArrayList<>();
        if (object.getTastes() != null) {
            for (Taste taste : object.getTastes()) {
                tastes.add(entityManager.find(Taste.class, taste.getId()));
            }
        }
        object.setCategories(categories);
        object.setOrigins(origins);
        object.setSeasons(seasons);
        object.setTastes(tastes);
        entityManager.persist(object);
    }

    @Override
    public Ingredient findById(Long id) {
        Query query = entityManager.createQuery("Select ingredients from Ingredient ingredients where id=:id");
        query.setParameter("id", id);
        Ingredient ingredient = null;
        try {
            ingredient = (Ingredient) query.getSingleResult();
        }catch (NoResultException e){
            e.printStackTrace();
        }

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
    @Override
    public List<Ingredient> getIngredientsInRecipes(List<Recipe> recipes){
        if (recipes == null){
            List<Ingredient> list = new ArrayList<>();
            return list;
        }
        Query query = entityManager.createQuery("select distinct i from Ingredient i join i.recipes r where r.id =:id");
        List<Ingredient> list = new ArrayList<>();

        for (Recipe recipe : recipes ){
            query.setParameter("id", recipe.getId());
            List<Ingredient> list1 = query.getResultList();
            for (Ingredient i : list1) {
                list.add(i);
            }
        }
        Set<Ingredient> hs = new HashSet<>();
        hs.addAll(list);
        list.clear();
        list.addAll(hs);
        return list;
    }
}
