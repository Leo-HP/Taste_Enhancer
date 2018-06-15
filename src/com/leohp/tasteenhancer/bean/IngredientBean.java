package com.leohp.tasteenhancer.bean;

import com.leohp.tasteenhancer.entity.Ingredient;
import com.leohp.tasteenhancer.service.IngredientService;
import com.leohp.tasteenhancer.service.RecipeService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.CollectionDataModel;
import javax.faces.model.DataModel;
import java.util.HashSet;
import java.util.Set;

@ManagedBean(name = "ingredientBean")
@SessionScoped
public class IngredientBean {

    @EJB
    private IngredientService ingredientService;

    @EJB
    private RecipeService recipeService;

    private DataModel ingredients;
    private Ingredient ingredient;
    private Long categoryId;
    private Long originId;
    private Long seasonId;
    private Long tasteId;
    private Long ingrdientId;
    private DataModel associations;
    private Set<Ingredient> selectedIngredients;
    private DataModel displaySelectedIngredients;

    public DataModel getDisplaySelectedIngredients() {
        selectedIngredients.add(ingredient);
        displaySelectedIngredients.setWrappedData(selectedIngredients);
        return displaySelectedIngredients;
    }

    public IngredientBean() {
        this.ingredient = new Ingredient();
        this.selectedIngredients = new HashSet<>();
        this.displaySelectedIngredients = new CollectionDataModel();
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
        if (ingredient.getId() != null) {
            //selectedIngredients.add(ingredient);
            displaySelectedIngredients.setWrappedData(selectedIngredients);
        }
        if (selectedIngredients.size() == 0) {
            Set<Ingredient> ingredients = new HashSet<>();
            ingredients.add(ingredient);
            associations = ingredientService.getCommonIngredients(ingredients);
        } else {
            associations = ingredientService.getCommonIngredients(selectedIngredients);
        }
        return associations;
    }

    public void unselect(Ingredient ingredient) {
        selectedIngredients.remove(ingredient);
        //this.ingredient = null;
        displaySelectedIngredients.setWrappedData(selectedIngredients);
    }

    public IngredientService getIngredientService() {
        return ingredientService;
    }

    public void setIngredientService(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    public String reset() {
        selectedIngredients.clear();
        //this.ingredient = null;
        displaySelectedIngredients.setWrappedData(selectedIngredients);
        return "taste-associator";
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

    public void setAssociations(DataModel associations) {
        this.associations = associations;
    }

    public Set<Ingredient> getSelectedIngredients() {
        return selectedIngredients;
    }

    public void setSelectedIngredients(Set<Ingredient> selectedIngredients) {
        this.selectedIngredients = selectedIngredients;
    }
}
