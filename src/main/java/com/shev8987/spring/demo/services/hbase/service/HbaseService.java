package com.shev8987.spring.demo.services.hbase.service;


import com.shev8987.spring.demo.services.hbase.dto.TableRequestDto;
import org.apache.hadoop.hbase.client.Table;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface HbaseService {

    Table createTable(TableRequestDto dto);

    void addColumns(TableRequestDto dto);

    void getById();

    Map<String, String> getAll(String tableName, String rowKey, String columnFamily);

    void update(TableRequestDto dto);

    void delete();

}
