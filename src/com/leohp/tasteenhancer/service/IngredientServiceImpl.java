package com.leohp.tasteenhancer.service;

import com.leohp.tasteenhancer.dao.*;
import com.leohp.tasteenhancer.entity.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @EJB
    private RecipeService recipeService;

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

    // add one category to the existing catgories of an ingredient
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
    // add one oringin to the existing origins of an ingredient
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
    // add one season to the existing seasons of an ingredient
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
    // add one tatse to the existing tastes of an ingredient
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
    public DataModel getAssociations() {
        if (associations == null) {
            associations = new ListDataModel();
            associations.setWrappedData(associations);
        }
        return associations;
    }

    // return the igredients which are found in recipes with all the ingredients in a list
    @Override
    public DataModel getCommonIngredients(Set<Ingredient> ingredients) {
        List<Recipe> recipes = recipeService.getCommonRecipes(ingredients);
        //List<Ingredient> ingredientsToRemove = new ArrayList<>();
        Set<Long> hs = new HashSet<>();
        Set<Long> hs1 = new HashSet<>();
        if (associations == null) {
            associations = new ListDataModel();
        }
        List<Ingredient> ingredientList = new ArrayList<>();
        for (Recipe recipe : recipes) {
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredientList.add(ingredient);
            }
        }
        /*for (Ingredient ingredient : ingredientList) {
            int occurences = Collections.frequency(ingredientList, ingredient);
            if (occurences != recipes.size()) {
                ingredientsToRemove.add(ingredient);
            }
        }*/
        for (Ingredient ingredient : ingredientList) {
            hs.add(ingredient.getId());
        }
        for (Ingredient ingredient : ingredients) {
            hs1.add(ingredient.getId());
        }
        hs.removeAll(hs1);
        ingredientList.clear();
        for (Long id : hs) {
            ingredientList.add(ingredientDao.findById(id));
        }

        ingredientList.removeAll(ingredients);
        associations.setWrappedData(ingredientList);
        return associations;
    }

    @Override
    public Ingredient findIngredientById(Long id) {
        Ingredient ingredient = ingredientDao.findById(id);
        return ingredient;
    }
}
