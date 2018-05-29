package com.leohp.tasteenhancer.dto;

import com.leohp.tasteenhancer.entity.Origin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DetailedOriginMapper {

    DetailedOriginMapper INSTANCE = Mappers.getMapper( DetailedOriginMapper.class );

    DetailedOriginDto originToDetailedOriginDto(Origin origin);
}
