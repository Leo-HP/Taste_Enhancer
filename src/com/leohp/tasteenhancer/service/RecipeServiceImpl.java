package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.dao.IngredientDao;
import com.leohp.tasteenhancer.dao.RecipeDao;
import com.leohp.tasteenhancer.entity.Ingredient;
import com.leohp.tasteenhancer.entity.Recipe;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.*;

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

    // add a list of ingredients to the existing ingredients of a recipe
    @Override
    public String addIngredients(Recipe recipe, List<Long> ingredientIds) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (Long id : ingredientIds) {
            ingredients.add(ingredientDao.findById(id));
        }
        List<Ingredient> baseIngredients = recipe.getIngredients();
        baseIngredients.addAll(ingredients);
        recipe.setIngredients(baseIngredients);
        recipeDao.update(recipe);
        recipes.setWrappedData(recipeDao.findAll());
        return "recipe-list";
    }

    // return the list of recipes common to all the ingredients of a list
    @Override
    public List<Recipe> getCommonRecipes(Set<Ingredient> ingredients) {
        List<Recipe> recipes = new ArrayList<>();
        List<Recipe> recipesToRemove = new ArrayList<>();
        List<Long> recipeIds = new ArrayList<>();
        Set<Recipe> hs = new HashSet<>();
        for (Ingredient ingredient : ingredients) {
            for (Recipe recipe : ingredient.getRecipes()) {
                recipes.add(recipe);
            }
        }
        for (Recipe recipe : recipes) {
            recipeIds.add(recipe.getId());
        }

        for (Recipe recipe : recipes) {
            int occurences = Collections.frequency(recipeIds, recipe.getId());
            if (occurences != ingredients.size()) {
                recipesToRemove.add(recipe);
            }
        }
        recipes.removeAll(recipesToRemove);
        hs.addAll(recipes);
        recipes.clear();
        recipes.addAll(hs);
        return recipes;
    }
}
