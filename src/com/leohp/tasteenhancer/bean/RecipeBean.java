package com.leohp.tasteenhancer.bean;

import com.leohp.tasteenhancer.entity.Recipe;
import com.leohp.tasteenhancer.service.RecipeService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import java.util.List;

@ManagedBean(name = "recipeBean")
@SessionScoped
public class RecipeBean {

    @EJB
    private RecipeService recipeService;

    private DataModel recipes;
    private Recipe recipe;
    private Long ingredientId;
    private List<Long> ingredientIds;

    public RecipeBean() {
        this.recipe = new Recipe();
    }

    public DataModel getRecipes() {
        recipes = recipeService.getRecipes();
        return recipes;
    }

    public String addRecipe() {
        recipe.setId(null);
        recipeService.addRecipe(recipe);
        return "success";
    }

    public void deleteRecipe() {
        recipe = (Recipe) recipes.getRowData();
        recipeService.deleteRecipe(recipe);
    }

    public String editRecipe() {
        recipe = (Recipe) recipes.getRowData();
        return "edit";
    }

    public String updateRecipe() {
        recipeService.updateRecipe(recipe);
        return "success";
    }

    public String addIngredient() {
        recipeService.addIngredient(recipe, ingredientId);
        return "success";
    }

    public String addIngredients() {
        recipeService.addIngredients(recipe, ingredientIds);
        return "success";
    }

    public RecipeService getRecipeService() {
        return recipeService;
    }

    public void setRecipeService(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    public void setRecipes(DataModel recipes) {
        this.recipes = recipes;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public List<Long> getIngredientIds() {
        return ingredientIds;
    }

    public void setIngredientIds(List<Long> ingredientIds) {
        this.ingredientIds = ingredientIds;
    }
}
