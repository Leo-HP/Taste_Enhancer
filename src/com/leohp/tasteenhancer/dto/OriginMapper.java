package com.leohp.tasteenhancer.dto;

import com.leohp.tasteenhancer.entity.Origin;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OriginMapper {

    OriginMapper INSTANCE = Mappers.getMapper( OriginMapper.class );

    OriginDto originToOriginDto(Origin origin);
}
