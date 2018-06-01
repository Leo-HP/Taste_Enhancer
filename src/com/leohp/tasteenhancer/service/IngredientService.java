package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.entity.*;

import javax.ejb.Local;
import javax.faces.model.DataModel;

@Local
public interface IngredientService {

    DataModel getIngredients();

    void addIngredient(Ingredient ingredient);

    String updateIngredient(Ingredient ingredient);

    String deleteCategory(Ingredient ingredient);

    String addCategorry(Category category);

    String addOrigin(Origin origin);

    String addSeason(Season season);

    String addTaste(Taste taste);
}
