package com.leohp.tasteenhancer.dto;

import com.leohp.tasteenhancer.entity.Taste;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TasteMapper {

    TasteMapper INSTANCE = Mappers.getMapper(TasteMapper.class);

    TasteDto tasteToTasteDto(Taste taste);
}
