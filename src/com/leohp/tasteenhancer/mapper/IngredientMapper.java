package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.*;
import com.leohp.tasteenhancer.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IngredientMapper {

    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);

    IngredientDto ingredientToIngredientDto(Ingredient ingredient);

    List<IngredientDto> ingredientToIngredientDto(List<Ingredient> ingredients);

    CategoryIngredientDto ingredientToCategoryIngredientDto(Ingredient ingredient);

    List<CategoryIngredientDto> ingredientToCategoryIngredientDto(List<Ingredient> ingredients);

    OriginIngredientDto ingredientToOriginIngredientDto(Ingredient ingredient);

    List<OriginIngredientDto> ingredientToOriginIngredientDto(List<Ingredient> ingredients);

    RecipeIngredientDto ingredientToRecipeIngredientDto(Ingredient ingredient);

    List<RecipeIngredientDto> ingredientToRecipeIngredientDto(List<Ingredient> ingredients);

    SeasonIngredientDto ingredientToSeasonIngredientDto(Ingredient ingredient);

    List<SeasonIngredientDto> ingredientToSeasonIngredientDto(List<Ingredient> ingredients);

    TasteIngredientDto ingredientToTasteIngredientDto(Ingredient ingredient);

    List<TasteIngredientDto> ingredientToTasteIngredientDto(List<Ingredient> ingredients);

    Ingredient recipeIngredientDtoToIngredient(RecipeIngredientDto recipeIngredientDto);

    List<Ingredient>recipeIngredientDtoToIngredient(List<RecipeIngredientDto> recipeIngredientDtos);
}
