package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.DetailedSeasonDto;
import com.leohp.tasteenhancer.dto.SeasonDto;
import com.leohp.tasteenhancer.entity.Season;

import java.util.ArrayList;
import java.util.List;

public class SeasonMapperImpl implements SeasonMapper {
    @Override
    public SeasonDto seasonToSeasonDto(Season season) {
        if (season == null) {
            return null;
        }
        SeasonDto seasonDto = new SeasonDto();
        seasonDto.setId(season.getId());
        seasonDto.setName(season.getName());
        return seasonDto;
    }

    @Override
    public List<SeasonDto> seasonToSeasonDto(List<Season> seasons) {
        if (seasons == null) {
            return null;
        }
        List<SeasonDto> list = new ArrayList<>();
        for (Season season : seasons) {
            list.add(seasonToSeasonDto(season));
        }
        return list;
    }

    @Override
    public DetailedSeasonDto seasonToDetailedSeasonDto(Season season) {
        if (season == null) {
            return null;
        }
        DetailedSeasonDto seasonDto = new DetailedSeasonDto();
        seasonDto.setId(season.getId());
        seasonDto.setName(season.getName());
        seasonDto.setIngredientList(IngredientMapper.INSTANCE.ingredientToSeasonIngredientDto(season.getIngredients()));
        return seasonDto;
    }

    @Override
    public Season seasonDtoToSeason(SeasonDto seasonDto) {
        if (seasonDto == null) {
            return null;
        }
        Season season = new Season();
        season.setId(seasonDto.getId());
        season.setName(seasonDto.getName());
        return season;
    }

    @Override
    public List<Season> seasonDtoToSeason(List<SeasonDto> seasonDtos) {
        if (seasonDtos == null) {
            return null;
        }
        List<Season> list = new ArrayList<>();
        for (SeasonDto season : seasonDtos) {
            list.add(seasonDtoToSeason(season));
        }
        return list;
    }
}
