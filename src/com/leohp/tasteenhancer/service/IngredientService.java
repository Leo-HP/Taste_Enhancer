package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.entity.*;

import javax.ejb.Local;
import javax.faces.model.DataModel;
import java.util.List;
import java.util.Set;

@Local
public interface IngredientService {

    DataModel getIngredients();

    DataModel getAssociations();

    DataModel getCommonIngredients(Set<Ingredient> ingredients);

    Ingredient findIngredientById(Long id);

    void addIngredient(Ingredient ingredient);

    String updateIngredient(Ingredient ingredient);

    String deleteIngredient(Ingredient ingredient);

    String addCategorry(Ingredient ingredient, Long categoryId);

    String addOrigin(Ingredient ingredient, Long originId);

    String addSeason(Ingredient ingredient, Long seasonId);

    String addTaste(Ingredient ingredient, Long tasteId);

}
