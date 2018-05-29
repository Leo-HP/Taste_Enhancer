package com.leohp.tasteenhancer.dto;

import com.leohp.tasteenhancer.entity.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DetailedRecipeMapper {

    DetailedRecipeMapper INSTANCE = Mappers.getMapper(DetailedRecipeMapper.class);

    DetailedRecipeDto recipeToDetailedRecipeDto(Recipe recipe);
}
