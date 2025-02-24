package com.shev8987.spring.demo.services.mapper;

import com.shev8987.spring.demo.services.dto.SingerDto;
import com.shev8987.spring.demo.services.entities.SingerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        config = EntityMapperConfig.class,
        uses = {
                AlbumMapper.class,
                InstrumentMapper.class
        }
)
public interface SingerMapper {


    SingerMapper MAPPER = Mappers.getMapper(SingerMapper.class);

    SingerDto entityToDto(SingerEntity entity);

    SingerEntity dtoToEntity(SingerDto entity);
}
