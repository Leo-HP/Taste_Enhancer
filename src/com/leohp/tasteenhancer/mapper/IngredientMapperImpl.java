package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.*;
import com.leohp.tasteenhancer.entity.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientMapperImpl implements IngredientMapper {
    @Override
    public IngredientDto ingredientToIngredientDto(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setCategoryDtoList(CategoryMapper.INSTANCE.categoryToCategoryDto(ingredient.getCategories()));
        ingredientDto.setOriginDtoList(OriginMapper.INSTANCE.originToOriginDto(ingredient.getOrigins()));
        //ingredientDto.setRecipeDtoList(RecipeMapper.INSTANCE.recipeToRecipeDto(ingredient.getRecipes()));
        ingredientDto.setSeasonDtoList(SeasonMapper.INSTANCE.seasonToSeasonDto(ingredient.getSeasons()));
        ingredientDto.setTasteDtoList(TasteMapper.INSTANCE.tasteToTasteDto(ingredient.getTastes()));
        return ingredientDto;
    }

    @Override
    public CategoryIngredientDto ingredientToCategoryIngredientDto(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }
        CategoryIngredientDto ingredientDto = new CategoryIngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setOriginDtoList(OriginMapper.INSTANCE.originToOriginDto(ingredient.getOrigins()));
        //ingredientDto.setRecipeDtoList(RecipeMapper.INSTANCE.recipeToRecipeDto(ingredient.getRecipes()));
        ingredientDto.setSeasonDtoList(SeasonMapper.INSTANCE.seasonToSeasonDto(ingredient.getSeasons()));
        ingredientDto.setTasteDtoList(TasteMapper.INSTANCE.tasteToTasteDto(ingredient.getTastes()));
        return ingredientDto;
    }

    @Override
    public OriginIngredientDto ingredientToOriginIngredientDto(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }
        OriginIngredientDto ingredientDto = new OriginIngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setCategoryDtoList(CategoryMapper.INSTANCE.categoryToCategoryDto(ingredient.getCategories()));
        //ingredientDto.setRecipeDtoList(RecipeMapper.INSTANCE.recipeToRecipeDto(ingredient.getRecipes()));
        ingredientDto.setSeasonDtoList(SeasonMapper.INSTANCE.seasonToSeasonDto(ingredient.getSeasons()));
        ingredientDto.setTasteDtoList(TasteMapper.INSTANCE.tasteToTasteDto(ingredient.getTastes()));
        return ingredientDto;
    }

    @Override
    public RecipeIngredientDto ingredientToRecipeIngredientDto(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }
        RecipeIngredientDto ingredientDto = new RecipeIngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setCategoryDtoList(CategoryMapper.INSTANCE.categoryToCategoryDto(ingredient.getCategories()));
        ingredientDto.setOriginDtoList(OriginMapper.INSTANCE.originToOriginDto(ingredient.getOrigins()));
        ingredientDto.setSeasonDtoList(SeasonMapper.INSTANCE.seasonToSeasonDto(ingredient.getSeasons()));
        ingredientDto.setTasteDtoList(TasteMapper.INSTANCE.tasteToTasteDto(ingredient.getTastes()));
        return ingredientDto;
    }

    @Override
    public SeasonIngredientDto ingredientToSeasonIngredientDto(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }
        SeasonIngredientDto ingredientDto = new SeasonIngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setCategoryDtoList(CategoryMapper.INSTANCE.categoryToCategoryDto(ingredient.getCategories()));
        ingredientDto.setOriginDtoList(OriginMapper.INSTANCE.originToOriginDto(ingredient.getOrigins()));
        //ingredientDto.setRecipeDtoList(RecipeMapper.INSTANCE.recipeToRecipeDto(ingredient.getRecipes()));
        ingredientDto.setTasteDtoList(TasteMapper.INSTANCE.tasteToTasteDto(ingredient.getTastes()));
        return ingredientDto;
    }

    @Override
    public TasteIngredientDto ingredientToTasteIngredientDto(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }
        TasteIngredientDto ingredientDto = new TasteIngredientDto();
        ingredientDto.setId(ingredient.getId());
        ingredientDto.setName(ingredient.getName());
        ingredientDto.setCategoryDtoList(CategoryMapper.INSTANCE.categoryToCategoryDto(ingredient.getCategories()));
        ingredientDto.setOriginDtoList(OriginMapper.INSTANCE.originToOriginDto(ingredient.getOrigins()));
        //ingredientDto.setRecipeDtoList(RecipeMapper.INSTANCE.recipeToRecipeDto(ingredient.getRecipes()));
        ingredientDto.setSeasonDtoList(SeasonMapper.INSTANCE.seasonToSeasonDto(ingredient.getSeasons()));
        return ingredientDto;
    }

    @Override
    public List<IngredientDto> ingredientToIngredientDto(List<Ingredient> ingredients) {
        if (ingredients == null) {
            return null;
        }
        List<IngredientDto> list = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            list.add(ingredientToIngredientDto(ingredient));
        }
        return list;
    }

    @Override
    public List<CategoryIngredientDto> ingredientToCategoryIngredientDto(List<Ingredient> ingredients) {
        if (ingredients == null) {
            return null;
        }
        List<CategoryIngredientDto> list = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            list.add(ingredientToCategoryIngredientDto(ingredient));
        }
        return list;
    }

    @Override
    public List<OriginIngredientDto> ingredientToOriginIngredientDto(List<Ingredient> ingredients) {
        if (ingredients == null) {
            return null;
        }
        List<OriginIngredientDto> list = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            list.add(ingredientToOriginIngredientDto(ingredient));
        }
        return list;
    }

    @Override
    public List<RecipeIngredientDto> ingredientToRecipeIngredientDto(List<Ingredient> ingredients) {
        if (ingredients == null) {
            return null;
        }
        List<RecipeIngredientDto> list = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            list.add(ingredientToRecipeIngredientDto(ingredient));
        }
        return list;
    }

    @Override
    public List<SeasonIngredientDto> ingredientToSeasonIngredientDto(List<Ingredient> ingredients) {
        if (ingredients == null) {
            return null;
        }
        List<SeasonIngredientDto> list = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            list.add(ingredientToSeasonIngredientDto(ingredient));
        }
        return list;
    }

    @Override
    public List<TasteIngredientDto> ingredientToTasteIngredientDto(List<Ingredient> ingredients) {
        if (ingredients == null) {
            return null;
        }
        List<TasteIngredientDto> list = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            list.add(ingredientToTasteIngredientDto(ingredient));
        }
        return list;
    }

    @Override
    public Ingredient recipeIngredientDtoToIngredient(RecipeIngredientDto recipeIngredientDto) {
        if (recipeIngredientDto == null) {
            return null;
        }
        Ingredient ingredient = new Ingredient();
        ingredient.setId(recipeIngredientDto.getId());
        ingredient.setName(recipeIngredientDto.getName());
        ingredient.setCategories(CategoryMapper.INSTANCE.categoryDtoToCategory(recipeIngredientDto.getCategoryDtoList()));
        ingredient.setOrigins(OriginMapper.INSTANCE.originDtoToOrigin(recipeIngredientDto.getOriginDtoList()));
        ingredient.setSeasons(SeasonMapper.INSTANCE.seasonDtoToSeason(recipeIngredientDto.getSeasonDtoList()));
        ingredient.setTastes(TasteMapper.INSTANCE.tasteDtoToTaste(recipeIngredientDto.getTasteDtoList()));
        return ingredient;
    }

    @Override
    public List<Ingredient> recipeIngredientDtoToIngredient(List<RecipeIngredientDto> recipeIngredientDtos) {
        if (recipeIngredientDtos == null) {
            return null;
        }
        List<Ingredient> list = new ArrayList<>();
        for (RecipeIngredientDto recipeIngredientDto : recipeIngredientDtos) {
            list.add(recipeIngredientDtoToIngredient(recipeIngredientDto));
        }
        return list;
    }
}
