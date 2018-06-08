package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.dao.*;
import com.leohp.tasteenhancer.entity.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class IngredientServiceImpl implements IngredientService {

    @EJB
    private IngredientDao ingredientDao;
    @EJB
    private CategoryDao categoryDao;
    @EJB
    private OriginDao originDao;
    @EJB
    private SeasonDao seasonDao;
    @EJB
    private TasteDao tasteDao;

    private DataModel ingredients;
    private DataModel associations;

    @Override
    public DataModel getIngredients() {
        if (ingredients == null) {
            ingredients = new ListDataModel();
            ingredients.setWrappedData(ingredientDao.findAll());
        }
        return ingredients;
    }



    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredientDao.create(ingredient);
        ingredients.setWrappedData(ingredientDao.findAll());
    }

    @Override
    public String updateIngredient(Ingredient ingredient) {
        ingredientDao.update(ingredient);
        ingredients.setWrappedData(ingredientDao.findAll());
        return "ingredient-list";
    }

    @Override
    public String deleteIngredient(Ingredient ingredient) {
        ingredientDao.remove(ingredient);
        ingredients.setWrappedData(ingredientDao.findAll());
        return "ingredient-list";
    }

    @Override
    public String addCategorry(Ingredient ingredient, Long categoryId) {
        Category category = categoryDao.findById(categoryId);
        List<Category> categories = ingredient.getCategories();
        categories.add(category);
        ingredient.setCategories(categories);
        ingredientDao.update(ingredient);
        ingredients.setWrappedData(ingredientDao.findAll());
        return "ingredient-list";
    }

    @Override
    public String addOrigin(Ingredient ingredient, Long originId) {
        Origin origin = originDao.findById(originId);
        List<Origin> origins = ingredient.getOrigins();
        origins.add(origin);
        ingredient.setOrigins(origins);
        ingredientDao.update(ingredient);
        ingredients.setWrappedData(ingredientDao.findAll());
        return "ingredient-list";
    }

    @Override
    public String addSeason(Ingredient ingredient, Long seasonId) {
        Season season = seasonDao.findById(seasonId);
        List<Season> seasons = ingredient.getSeasons();
        seasons.add(season);
        ingredient.setSeasons(seasons);
        ingredientDao.update(ingredient);
        ingredients.setWrappedData(ingredientDao.findAll());
        return "ingredient-list";
    }

    @Override
    public String addTaste(Ingredient ingredient, Long tasteId) {
        Taste taste = tasteDao.findById(tasteId);
        List<Taste> tastes = ingredient.getTastes();
        tastes.add(taste);
        ingredient.setTastes(tastes);
        ingredientDao.update(ingredient);
        ingredients.setWrappedData(ingredientDao.findAll());
        return "ingredient-list";
    }

    @Override
    public DataModel getIngredientsInRecipes(List<Recipe> recipes) {
        if (associations == null) {
            associations = new ListDataModel();
            associations.setWrappedData(ingredientDao.getIngredientsInRecipes(recipes));
        }
        return associations;
    }

    @Override
    public List<Ingredient> getCommonIngredients(List<Recipe> recipes) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (Recipe recipe : recipes){
            for (Ingredient ingredient : recipe.getIngredients()){
                ingredients.add(ingredient);
            }
        }
        for (Ingredient ingredient : ingredients){
            int occurences = Collections.frequency(ingredients, ingredient);
            if (occurences != recipes.size()){
                ingredients.remove(ingredient);
            }
        }
        return ingredients;
    }

    @Override
    public Ingredient findIngredientById(Long id) {
        Ingredient ingredient = ingredientDao.findById(id);
        return ingredient;
    }
}
