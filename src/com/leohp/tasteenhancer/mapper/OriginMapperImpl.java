package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.DetailedOriginDto;
import com.leohp.tasteenhancer.dto.OriginDto;
import com.leohp.tasteenhancer.entity.Origin;

import java.util.ArrayList;
import java.util.List;

public class OriginMapperImpl implements OriginMapper {

    @Override
    public OriginDto originToOriginDto(Origin origin) {
        if (origin == null) {
            return null;
        }
        OriginDto originDto = new OriginDto();
        originDto.setId(origin.getId());
        originDto.setName(origin.getName());
        return originDto;
    }

    @Override
    public List<OriginDto> originToOriginDto(List<Origin> origins) {
        if (origins == null) {
            return null;
        }
        List<OriginDto> list = new ArrayList<>();
        for (Origin origin : origins) {
            list.add(originToOriginDto(origin));
        }
        return list;
    }

    @Override
    public DetailedOriginDto originToDetailedOriginDto(Origin origin) {
        if (origin == null) {
            return null;
        }
        DetailedOriginDto originDto = new DetailedOriginDto();
        originDto.setId(origin.getId());
        originDto.setName(origin.getName());
        originDto.setIngredientList(IngredientMapper.INSTANCE.ingredientToOriginIngredientDto(origin.getIngredients()));
        return originDto;
    }

    @Override
    public Origin originDtoToOrigin(OriginDto originDto) {
        if (originDto == null) {
            return null;
        }
        Origin origin = new Origin();
        origin.setId(originDto.getId());
        origin.setName(originDto.getName());
        return origin;
    }

    @Override
    public List<Origin> originDtoToOrigin(List<OriginDto> originDtos) {
        if (originDtos == null) {
            return null;
        }
        List<Origin> list = new ArrayList<>();
        for (OriginDto origin : originDtos) {
            list.add(originDtoToOrigin(origin));
        }
        return list;
    }
}
