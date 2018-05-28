package com.leohp.tasteenhancer.dto;

import com.leohp.tasteenhancer.entity.Origin;

import java.util.List;

public class IngredientDto {

    private Long id;
    private String name;
    private List<CategoryDto> categoryDtoList;
    private List<OriginDto> originDtoList;
    private List<RecipeDto> recipeDtoList;
    private List<SeasonDto> seasonDtoList;
    private List<TasteDto> tasteDtoList;
}
