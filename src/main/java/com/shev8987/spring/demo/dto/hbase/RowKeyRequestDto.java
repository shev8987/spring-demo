package com.shev8987.spring.demo.dto.hbase;

import com.shev8987.spring.demo.services.hbase.entities.ColumnFamilyEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RowKeyRequestDto {


    /**
     * Первичный ключ
     */
    String rowKeyName;

    /**
     * Семейство колонок
     */
    List<ColumnFamilyEntity> columnFamily;
}
