package com.leohp.tasteenhancer.dao;

import com.leohp.tasteenhancer.entity.Ingredient;
import com.leohp.tasteenhancer.entity.Recipe;

import java.util.List;

/*
 ** DAO interface for ingredient extending the generic DAO
 */
public interface IngredientDao extends GenericDao<Ingredient> {

    // method allowing to retrieve all ingredients in a list of recipes
    List<Ingredient> getIngredientsInRecipes(List<Recipe> recipes);
}
