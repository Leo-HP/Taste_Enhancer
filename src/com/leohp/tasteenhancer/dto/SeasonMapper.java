package com.leohp.tasteenhancer.dto;

import com.leohp.tasteenhancer.entity.Season;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeasonMapper {

    SeasonMapper INSTANCE = Mappers.getMapper( SeasonMapper.class );

    SeasonDto seasonToSeasonDto(Season season);
}
