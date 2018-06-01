package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.entity.Ingredient;
import com.leohp.tasteenhancer.entity.Recipe;

import javax.ejb.Local;
import javax.faces.model.DataModel;
import java.util.List;

@Local
public interface RecipeService {
    DataModel getRecipes();

    void addRecipe();

    String updateRecipe(Recipe recipe);

    String deleteRecipe(Recipe recipe);

    String addIngredient(Recipe recipe, Ingredient ingredient);

    String addIngredients(Recipe recipe, List<Ingredient> ingredients);
}
