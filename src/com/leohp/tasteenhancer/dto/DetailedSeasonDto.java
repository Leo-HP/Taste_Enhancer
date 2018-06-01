package com.leohp.tasteenhancer.dto;

import java.io.Serializable;
import java.util.List;

public class DetailedSeasonDto implements Serializable {

    private Long id;
    private String name;

    private List<SeasonIngredientDto> ingredientList;

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

    public List<SeasonIngredientDto> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<SeasonIngredientDto> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public DetailedSeasonDto() {

    }

    private DetailedSeasonDto(Long id, String name, List<SeasonIngredientDto> ingredientDtoList) {
        this.id = id;
        this.name = name;
        this.ingredientList = ingredientDtoList;
    }
}
