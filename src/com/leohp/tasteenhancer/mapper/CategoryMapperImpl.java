package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.CategoryDto;
import com.leohp.tasteenhancer.dto.DetailedCategoryDto;
import com.leohp.tasteenhancer.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryDto categoryToCategoryDto(Category category) {
        if (category == null) {
            return null;
        }
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    @Override
    public List<CategoryDto> categoryToCategoryDto(List<Category> categories) {
        if (categories == null) {
            return null;
        }
        List<CategoryDto> list = new ArrayList<>();
        for (Category category : categories) {
            list.add(categoryToCategoryDto(category));
        }
        return list;
    }

    @Override
    public DetailedCategoryDto categoryToDetailedCategoryDto(Category category) {
        if (category == null) {
            return null;
        }
        DetailedCategoryDto categoryDto = new DetailedCategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setIngredientList(IngredientMapper.INSTANCE.ingredientToCategoryIngredientDto(category.getIngredients()));
        return categoryDto;
    }

    @Override
    public Category categoryDtoToCategory(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        return category;
    }

    @Override
    public List<Category> categoryDtoToCategory(List<CategoryDto> categoryDtos) {
        if (categoryDtos == null) {
            return null;
        }
        List<Category> list = new ArrayList<>();
        for (CategoryDto category : categoryDtos) {
            list.add(categoryDtoToCategory(category));
        }
        return list;
    }
}
