package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.DetailedSeasonDto;
import com.leohp.tasteenhancer.dto.SeasonDto;
import com.leohp.tasteenhancer.entity.Season;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SeasonMapper {

    SeasonMapper INSTANCE = Mappers.getMapper(SeasonMapper.class);

    SeasonDto seasonToSeasonDto(Season season);

    List<SeasonDto> seasonToSeasonDto(List<Season> seasons);

    DetailedSeasonDto seasonToDetailedSeasonDto(Season season);

    Season seasonDtoToSeason(SeasonDto seasonDto);

    List<Season> seasonDtoToSeason(List<SeasonDto> seasonDtos);
}
