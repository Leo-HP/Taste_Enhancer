package com.leohp.tasteenhancer.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.leohp.tasteenhancer.entity.Category;

@Mapper
public interface DetailedCategoryMapper {

    DetailedCategoryMapper INSTANCE = Mappers.getMapper( DetailedCategoryMapper.class );

    DetailedCategoryDto categoryToCategoryDto(Category category);
}
