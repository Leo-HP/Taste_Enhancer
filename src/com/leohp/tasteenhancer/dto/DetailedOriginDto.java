package com.leohp.tasteenhancer.dto;

import java.io.Serializable;
import java.util.List;

public class DetailedOriginDto implements Serializable {

    private Long id;
    private String name;

    private List<OriginIngredientDto> ingredientList;

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

    public List<OriginIngredientDto> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<OriginIngredientDto> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public DetailedOriginDto() {

    }

    private DetailedOriginDto(Long id, String name, List<OriginIngredientDto> ingredientDtoList) {
        this.id = id;
        this.name = name;
        this.ingredientList = ingredientDtoList;
    }
}
