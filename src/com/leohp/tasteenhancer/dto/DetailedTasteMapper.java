package com.leohp.tasteenhancer.dto;

import com.leohp.tasteenhancer.entity.Taste;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DetailedTasteMapper {

    DetailedTasteMapper INSTANCE = Mappers.getMapper(DetailedTasteMapper.class);

    DetailedTasteDto tasteToDetailedTasteDto(Taste taste);
}
