package com.leohp.tasteenhancer.mapper;

import com.leohp.tasteenhancer.dto.DetailedOriginDto;
import com.leohp.tasteenhancer.dto.OriginDto;
import com.leohp.tasteenhancer.entity.Origin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OriginMapper {

    OriginMapper INSTANCE = Mappers.getMapper(OriginMapper.class);

    OriginDto originToOriginDto(Origin origin);

    List<OriginDto> originToOriginDto(List<Origin> origins);

    DetailedOriginDto originToDetailedOriginDto(Origin origin);

    Origin originDtoToOrigin(OriginDto originDto);

    List<Origin> originDtoToOrigin(List<OriginDto> originDtos);

}
