package com.leohp.tasteenhancer.dto;

import java.util.List;

public class OriginIngredientDto {

    private Long id;
    private String name;
    private List<CategoryDto> categoryDtoList;
    private List<RecipeDto> recipeDtoList;
    private List<SeasonDto> seasonDtoList;
    private List<TasteDto> tasteDtoList;

    public OriginIngredientDto() {
    }

    public OriginIngredientDto(String name, List<CategoryDto> categoryDtoList, List<RecipeDto> recipeDtoList, List<SeasonDto> seasonDtoList, List<TasteDto> tasteDtoList) {
        this.name = name;
        this.categoryDtoList = categoryDtoList;
        this.recipeDtoList = recipeDtoList;
        this.seasonDtoList = seasonDtoList;
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

    public List<RecipeDto> getRecipeDtoList() {
        return recipeDtoList;
    }

    public void setRecipeDtoList(List<RecipeDto> recipeDtoList) {
        this.recipeDtoList = recipeDtoList;
    }

    public List<SeasonDto> getSeasonDtoList() {
        return seasonDtoList;
    }

    public void setSeasonDtoList(List<SeasonDto> seasonDtoList) {
        this.seasonDtoList = seasonDtoList;
    }

    public List<TasteDto> getTasteDtoList() {
        return tasteDtoList;
    }

    public void setTasteDtoList(List<TasteDto> tasteDtoList) {
        this.tasteDtoList = tasteDtoList;
    }
}
