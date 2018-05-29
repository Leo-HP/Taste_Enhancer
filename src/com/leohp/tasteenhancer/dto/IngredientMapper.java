package com.leohp.tasteenhancer.dto;

import com.leohp.tasteenhancer.entity.Ingredient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IngredientMapper {

    IngredientMapper INSTANCE = Mappers.getMapper( IngredientMapper.class );

    IngredientDto IngredientToIngredientDto(Ingredient ingredient);
}
