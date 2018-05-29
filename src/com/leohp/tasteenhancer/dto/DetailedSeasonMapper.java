package com.leohp.tasteenhancer.dto;

import com.leohp.tasteenhancer.entity.Season;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DetailedSeasonMapper {

    DetailedSeasonMapper INSTANCE = Mappers.getMapper(DetailedSeasonMapper.class);

    DetailedSeasonDto seasonToDetailedSeasonDto(Season season);
}
