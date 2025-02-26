package com.shev8987.spring.demo.services.hbase.repository;

import com.shev8987.spring.demo.services.hbase.entities.TableEntity;
import org.apache.hadoop.hbase.client.Table;

import java.util.Map;

public interface HbaseRepository {

    Table createTable(TableEntity table);

    void addColumns(TableEntity entity);

    void getById(String tableName, String rowKey, String columnFamily, String column);

    Map<String, String> getAll(String tableName, String rowKey, String columnFamily);

    void update(TableEntity table);

    void delete(String tableName);
}
