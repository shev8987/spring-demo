package com.shev8987.spring.demo.services.hbase.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RowKeyEntity {


    /**
     * Первичный ключ
     */
    String rowKeyName;

    /**
     * Семейство колонок
     */
    List<ColumnFamilyEntity> columnFamily;
}
