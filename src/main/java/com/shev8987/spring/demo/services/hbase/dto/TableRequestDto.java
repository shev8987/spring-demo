package com.shev8987.spring.demo.dto.hbase;

import com.shev8987.spring.demo.services.hbase.entities.RowKeyEntity;
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
