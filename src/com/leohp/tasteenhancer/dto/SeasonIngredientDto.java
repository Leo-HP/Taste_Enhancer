package com.leohp.tasteenhancer.dto;

import java.util.List;

public class SeasonIngredientDto {

    private Long id;
    private String name;
    private List<CategoryDto> categoryDtoList;
    private List<OriginDto> originDtoList;
    private List<RecipeDto> recipeDtoList;
    private List<TasteDto> tasteDtoList;

    public SeasonIngredientDto() {
    }

    public SeasonIngredientDto(String name, List<CategoryDto> categoryDtoList, List<OriginDto> originDtoList, List<RecipeDto> recipeDtoList, List<TasteDto> tasteDtoList) {
        this.name = name;
        this.categoryDtoList = categoryDtoList;
        this.originDtoList = originDtoList;
        this.recipeDtoList = recipeDtoList;
        this.tasteDtoList = tasteDtoList;
    }

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

    public List<CategoryDto> getCategoryDtoList() {
        return categoryDtoList;
    }

    public void setCategoryDtoList(List<CategoryDto> categoryDtoList) {
        this.categoryDtoList = categoryDtoList;
    }

    public List<OriginDto> getOriginDtoList() {
        return originDtoList;
    }

    public void setOriginDtoList(List<OriginDto> originDtoList) {
        this.originDtoList = originDtoList;
    }

    public List<RecipeDto> getRecipeDtoList() {
        return recipeDtoList;
    }

    public void setRecipeDtoList(List<RecipeDto> recipeDtoList) {
        this.recipeDtoList = recipeDtoList;
    }

    public List<TasteDto> getTasteDtoList() {
        return tasteDtoList;
    }

    public void setTasteDtoList(List<TasteDto> tasteDtoList) {
        this.tasteDtoList = tasteDtoList;
    }
}
