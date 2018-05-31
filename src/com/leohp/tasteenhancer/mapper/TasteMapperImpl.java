package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.DetailedTasteDto;
import com.leohp.tasteenhancer.dto.TasteDto;
import com.leohp.tasteenhancer.entity.Taste;

import java.util.ArrayList;
import java.util.List;

public class TasteMapperImpl implements TasteMapper {
    @Override
    public TasteDto tasteToTasteDto(Taste taste) {
        if (taste == null) {
            return null;
        }
        TasteDto tasteDto = new TasteDto();
        tasteDto.setId(taste.getId());
        tasteDto.setName(taste.getName());
        return tasteDto;
    }

    @Override
    public List<TasteDto> tasteToTasteDto(List<Taste> tastes) {
        if (tastes == null) {
            return null;
        }
        List<TasteDto> list = new ArrayList<>();
        for (Taste taste : tastes) {
            list.add(tasteToTasteDto(taste));
        }
        return list;
    }

    @Override
    public DetailedTasteDto tasteToDetailedTasteDto(Taste taste) {
        if (taste == null) {
            return null;
        }
        DetailedTasteDto tasteDto = new DetailedTasteDto();
        tasteDto.setId(taste.getId());
        tasteDto.setName(taste.getName());
        tasteDto.setIngredientList(IngredientMapper.INSTANCE.ingredientToTasteIngredientDto(taste.getIngredients()));
        return tasteDto;
    }

    @Override
    public Taste tasteDtoToTaste(TasteDto tasteDto) {
        if (tasteDto == null) {
            return null;
        }
        Taste taste = new Taste();
        taste.setId(tasteDto.getId());
        taste.setName(tasteDto.getName());
        return taste;
    }

    @Override
    public List<Taste> tasteDtoToTaste(List<TasteDto> tasteDtos) {
        if (tasteDtos == null) {
            return null;
        }
        List<Taste> list = new ArrayList<>();
        for (TasteDto taste : tasteDtos) {
            list.add(tasteDtoToTaste(taste));
        }
        return list;
    }
}
