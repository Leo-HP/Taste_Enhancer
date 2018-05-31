package com.leohp.tasteenhancer.dto;

import java.io.Serializable;
import java.util.List;

public class DetailedTasteDto implements Serializable {

    private Long id;
    private String name;

    private List<TasteIngredientDto> ingredientList;

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

    public List<TasteIngredientDto> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<TasteIngredientDto> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public DetailedTasteDto() {

    }

    private DetailedTasteDto(Long id, String name, List<TasteIngredientDto> ingredientDtoList) {
        this.id = id;
        this.name = name;
        this.ingredientList = ingredientDtoList;
    }
}
