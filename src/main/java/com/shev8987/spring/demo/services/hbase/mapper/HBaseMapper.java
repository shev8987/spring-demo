package com.shev8987.spring.demo.services.hbase.mapper;

import com.shev8987.spring.demo.services.hbase.dto.TableRequestDto;
import com.shev8987.spring.demo.services.hbase.entities.TableEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HBaseMapper{

    HBaseMapper MAPPER = Mappers.getMapper(HBaseMapper.class);

    TableEntity toEntity(TableRequestDto dto);

    TableRequestDto toDto(TableEntity entity);
}
