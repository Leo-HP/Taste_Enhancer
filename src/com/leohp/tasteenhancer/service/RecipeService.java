package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.entity.Ingredient;
import com.leohp.tasteenhancer.entity.Recipe;

import javax.ejb.Local;
import javax.faces.model.DataModel;
import java.util.List;
import java.util.Set;

@Local
public interface RecipeService {
    DataModel getRecipes();

    void addRecipe(Recipe recipe);

    String updateRecipe(Recipe recipe);

    String deleteRecipe(Recipe recipe);

    String addIngredient(Recipe recipe, Long ingredientId);

    String addIngredients(Recipe recipe, List<Long> ingredientIds);

    List<Recipe> getCommonRecipes(Set<Ingredient> ingredients);
}
