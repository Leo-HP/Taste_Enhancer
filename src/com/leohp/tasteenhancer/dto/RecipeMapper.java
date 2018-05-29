package com.leohp.tasteenhancer.dto;

import com.leohp.tasteenhancer.entity.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper( RecipeMapper.class );

    RecipeDto recipeToRecipeDto(Recipe recipe);
}
