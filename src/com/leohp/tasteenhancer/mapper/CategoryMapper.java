package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.CategoryDto;
import com.leohp.tasteenhancer.dto.DetailedCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.leohp.tasteenhancer.entity.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );

    CategoryDto categoryToCategoryDto(Category category);

    List<CategoryDto> categoryToCategoryDto(List<Category> categories);

    DetailedCategoryDto categoryToDetailedCategoryDto(Category category);

    Category categoryDtoToCategory(CategoryDto categoryDto);

    List<Category> categoryDtoToCategory(List<CategoryDto> categoryDtos);
}
