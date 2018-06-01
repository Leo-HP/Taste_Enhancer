package com.leohp.tasteenhancer.dto;

import java.io.Serializable;
import java.util.List;

public class DetailedRecipeDto implements Serializable {
    private Long id;
    private String name;

    private List<RecipeIngredientDto> ingredientList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeIngredientDto> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<RecipeIngredientDto> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public DetailedRecipeDto() {

    }

    private DetailedRecipeDto(Long id, String name, List<RecipeIngredientDto> ingredientDtoList) {
        this.id = id;
        this.name = name;
        this.ingredientList = ingredientDtoList;
    }
}
