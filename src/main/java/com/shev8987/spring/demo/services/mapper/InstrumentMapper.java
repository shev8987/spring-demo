package com.shev8987.spring.demo.services.mapper;

import com.shev8987.spring.demo.services.dto.InstrumentDto;
import com.shev8987.spring.demo.services.entities.InstrumentEntity;
import org.mapstruct.Mapper;

@Mapper(
        config = EntityMapperConfig.class
)
public interface InstrumentMapper {

    InstrumentDto entityToDto(InstrumentEntity entity);

    InstrumentEntity dtoToEntity(InstrumentDto dto);
}
