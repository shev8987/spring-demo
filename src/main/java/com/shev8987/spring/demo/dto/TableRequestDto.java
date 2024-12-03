package com.shev8987.spring.demo.dto;

import com.shev8987.spring.demo.model.hbase.RowKeyEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
