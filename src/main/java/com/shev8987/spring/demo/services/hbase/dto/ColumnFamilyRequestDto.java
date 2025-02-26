package com.shev8987.spring.demo.services.hbase.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ColumnFamilyRequestDto {

    /**
     * Наименование семейства колонок
     */
    String name;

    /**
     * Колонки
     * Ключ - имя колонки
     */
    Map<String, String> columns;
}
