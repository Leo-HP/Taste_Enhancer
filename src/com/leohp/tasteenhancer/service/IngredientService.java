package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.dao.IngredientDao;
import com.leohp.tasteenhancer.entity.*;

import javax.ejb.Local;
import javax.faces.model.DataModel;
import java.util.List;

@Local
public interface IngredientService {

    DataModel getIngredients();

    List<Ingredient> getCommonIngredients(List<Recipe> recipes);

    Ingredient findIngredientById(Long id);

    void addIngredient(Ingredient ingredient);

    String updateIngredient(Ingredient ingredient);

    String deleteIngredient(Ingredient ingredient);

    String addCategorry(Ingredient ingredient, Long categoryId);

    String addOrigin(Ingredient ingredient, Long originId);

    String addSeason(Ingredient ingredient, Long seasonId);

    String addTaste(Ingredient ingredient, Long tasteId);

    DataModel getIngredientsInRecipes(List<Recipe> recipes);
}
