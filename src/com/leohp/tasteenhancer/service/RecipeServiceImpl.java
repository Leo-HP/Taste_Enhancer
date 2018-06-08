package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.dao.IngredientDao;
import com.leohp.tasteenhancer.dao.RecipeDao;
import com.leohp.tasteenhancer.entity.Ingredient;
import com.leohp.tasteenhancer.entity.Recipe;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
public class RecipeServiceImpl implements RecipeService {

    @EJB
    private RecipeDao recipeDao;
    @EJB
    private IngredientDao ingredientDao;

    private DataModel recipes;

    @Override
    public DataModel getRecipes() {
        if (recipes == null) {
            recipes = new ListDataModel();
            recipes.setWrappedData(recipeDao.findAll());
        }
        return recipes;
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipeDao.create(recipe);
        recipes.setWrappedData(recipeDao.findAll());
    }

    @Override
    public String updateRecipe(Recipe recipe) {
        recipeDao.update(recipe);
        recipes.setWrappedData(recipeDao.findAll());
        return "recipe-list";
    }

    @Override
    public String deleteRecipe(Recipe recipe) {
        recipeDao.remove(recipe);
        recipes.setWrappedData(recipeDao.findAll());
        return "recipe-list";
    }

    @Override
    public String addIngredient(Recipe recipe, Long ingredientId) {
        Ingredient ingredient = ingredientDao.findById(ingredientId);
        List<Ingredient> ingredients = recipe.getIngredients();
        ingredients.add(ingredient);
        recipe.setIngredients(ingredients);
        recipeDao.update(recipe);
        recipes.setWrappedData(recipeDao.findAll());
        return "recipe-list";
    }

    @Override
    public String addIngredients(Recipe recipe, List<Long> ingredientIds) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (Long id : ingredientIds) {
            ingredients.add(ingredientDao.findById(id));
        }
        List<Ingredient> baseIngredients = recipe.getIngredients();
        for (Ingredient ingredient : ingredients) {
            baseIngredients.add(ingredient);
        }
        recipe.setIngredients(baseIngredients);
        recipeDao.update(recipe);
        recipes.setWrappedData(recipeDao.findAll());
        return "recipe-list";
    }

    @Override
    public List<Recipe> getCommonRecipes(List<Ingredient> ingredients) {
        List<Recipe> recipes = new ArrayList<>();
        for (Ingredient ingredient : ingredients){
            for (Recipe recipe : ingredient.getRecipes()){
                recipes.add(recipe);
            }
        }
        for (Recipe recipe : recipes){
            int occurences = Collections.frequency(recipes, recipe);
            if (occurences != ingredients.size()){
                recipes.remove(recipe);
            }
        }
        return recipes;
    }
}
