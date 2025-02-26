package com.shev8987.spring.demo.services.hbase.dto;

import com.shev8987.spring.demo.services.hbase.entities.RowKeyEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class TableRequestDto {

    /**
     * Имя таблицы
     */
    String table;

    /**
     * Первичные ключи
     */
    List<RowKeyEntity> rowKey;

}
