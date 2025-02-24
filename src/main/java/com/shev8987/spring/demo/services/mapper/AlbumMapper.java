package com.shev8987.spring.demo.services.mapper;

import com.shev8987.spring.demo.services.dto.AlbumDto;
import com.shev8987.spring.demo.services.dto.SingerDto;
import com.shev8987.spring.demo.services.entities.AlbumEntity;
import com.shev8987.spring.demo.services.entities.SingerEntity;
import org.mapstruct.Mapper;

@Mapper(
        config = EntityMapperConfig.class
)
public interface AlbumMapper {

    AlbumDto entityToDto(AlbumEntity entity);

    AlbumEntity dtoToEntity(AlbumDto entity);
}
