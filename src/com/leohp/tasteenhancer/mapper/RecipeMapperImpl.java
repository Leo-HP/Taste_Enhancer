package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.DetailedRecipeDto;
import com.leohp.tasteenhancer.dto.RecipeDto;
import com.leohp.tasteenhancer.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeMapperImpl implements RecipeMapper {
    @Override
    public RecipeDto recipeToRecipeDto(Recipe recipe) {
        if (recipe == null) {
            return null;
        }
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setName(recipe.getName());
        return recipeDto;
    }

    @Override
    public List<RecipeDto> recipeToRecipeDto(List<Recipe> recipes) {
        if (recipes == null) {
            return null;
        }
        List<RecipeDto> list = new ArrayList<>();
        for (Recipe recipe : recipes) {
            list.add(recipeToRecipeDto(recipe));
        }
        return list;
    }

    @Override
    public DetailedRecipeDto recipeToDetailedRecipeDto(Recipe recipe) {
        if (recipe == null) {
            return null;
        }
        DetailedRecipeDto recipeDto = new DetailedRecipeDto();
        recipeDto.setId(recipe.getId());
        recipeDto.setName(recipe.getName());
        recipeDto.setIngredientList(IngredientMapper.INSTANCE.ingredientToRecipeIngredientDto(recipe.getIngredients()));
        return recipeDto;
    }

    @Override
    public Recipe recipeDtoToRecipe(RecipeDto recipeDto) {
        if (recipeDto == null) {
            return null;
        }
        Recipe recipe = new Recipe();
        recipe.setId(recipeDto.getId());
        recipe.setName(recipeDto.getName());
        return recipe;
    }

    @Override
    public List<Recipe> recipeDtoToRecipe(List<RecipeDto> recipeDtos) {
        if (recipeDtos == null) {
            return null;
        }
        List<Recipe> list = new ArrayList<>();
        for (RecipeDto recipe : recipeDtos) {
            list.add(recipeDtoToRecipe(recipe));
        }
        return list;
    }
}
