package com.leohp.tasteenhancer.dao;

import com.leohp.tasteenhancer.entity.Ingredient;
import com.leohp.tasteenhancer.entity.Recipe;

import java.util.List;

public interface IngredientDao extends GenericDao<Ingredient> {

    List<Ingredient> getIngredientsInRecipes(List<Recipe> recipes);
}
