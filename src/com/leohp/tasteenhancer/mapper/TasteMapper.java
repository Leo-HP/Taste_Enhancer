package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.DetailedTasteDto;
import com.leohp.tasteenhancer.dto.TasteDto;
import com.leohp.tasteenhancer.entity.Taste;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TasteMapper {

    TasteMapper INSTANCE = Mappers.getMapper(TasteMapper.class);

    TasteDto tasteToTasteDto(Taste taste);

    List<TasteDto> tasteToTasteDto(List<Taste> tastes);

    DetailedTasteDto tasteToDetailedTasteDto(Taste taste);

    Taste tasteDtoToTaste(TasteDto tasteDto);

    List<Taste> tasteDtoToTaste(List<TasteDto> tasteDtos);
}
