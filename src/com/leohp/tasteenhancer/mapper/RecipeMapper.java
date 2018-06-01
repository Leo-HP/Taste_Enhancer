package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.DetailedRecipeDto;
import com.leohp.tasteenhancer.dto.RecipeDto;
import com.leohp.tasteenhancer.entity.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDto recipeToRecipeDto(Recipe recipe);

    List<RecipeDto> recipeToRecipeDto(List<Recipe> recipes);

    DetailedRecipeDto recipeToDetailedRecipeDto(Recipe recipe);

    Recipe recipeDtoToRecipe(RecipeDto recipeDto);

    List<Recipe> recipeDtoToRecipe(List<RecipeDto> recipeDtos);
}
