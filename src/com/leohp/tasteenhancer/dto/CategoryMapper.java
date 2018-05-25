package com.leohp.tasteenhancer.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.leohp.tasteenhancer.entity.Category;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper( CategoryMapper.class );

    CategoryDto categoryToCategoryDto(Category category);
}
