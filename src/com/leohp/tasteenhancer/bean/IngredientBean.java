package com.leohp.tasteenhancer.bean;

import com.leohp.tasteenhancer.entity.Ingredient;
import com.leohp.tasteenhancer.service.IngredientService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import java.util.List;

@ManagedBean(name = "ingredientBean")
@SessionScoped
public class IngredientBean {

    @EJB
    private IngredientService ingredientService;

    private DataModel ingredients;
    private Ingredient ingredient;
    private Long categoryId;
    private Long originId;
    private Long seasonId;
    private Long tasteId;
    private Long ingrdientId;
    private DataModel associations;
    private List<Ingredient> selectedIngredients;

    public IngredientBean() {
        this.ingredient = new Ingredient();
    }

    public DataModel getIngredients() {
        ingredients = ingredientService.getIngredients();
        return ingredients;
    }


    public String addIngredient() {
        ingredient.setId(null);
        ingredientService.addIngredient(ingredient);
        return "success";
    }

    public void deleteIngredient() {
        ingredient = (Ingredient) ingredients.getRowData();
        ingredientService.deleteIngredient(ingredient);
    }

    public String editIngredient() {
        ingredient = (Ingredient) ingredients.getRowData();
        return "edit";
    }

    public String updateIngredient() {
        ingredientService.updateIngredient(ingredient);
        return "success";
    }

    public String addCategory() {
        ingredientService.addCategorry(ingredient, categoryId);
        return "success";
    }

    public String addOrigin() {
        ingredientService.addOrigin(ingredient, originId);
        return "success";
    }

    public String addSeason() {
        ingredientService.addSeason(ingredient, seasonId);
        return "success";
    }

    public String addTaste() {
        ingredientService.addTaste(ingredient, tasteId);
        return "success";
    }

    public DataModel getAssociations() {
        associations = ingredientService.getIngredientsInRecipes(ingredient.getRecipes());

        return associations;
    }

    public IngredientService getIngredientService() {
        return ingredientService;
    }

    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    public void setIngredients(DataModel ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getOriginId() {
        return originId;
    }

    public void setOriginId(Long originId) {
        this.originId = originId;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public Long getTasteId() {
        return tasteId;
    }

    public void setTasteId(Long tasteId) {
        this.tasteId = tasteId;
    }
}
