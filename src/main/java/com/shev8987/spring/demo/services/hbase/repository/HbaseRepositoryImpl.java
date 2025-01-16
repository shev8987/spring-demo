package com.shev8987.spring.demo.services.hbase.repository;

import com.shev8987.spring.demo.services.hbase.config.HBaseConfig;
import lombok.RequiredArgsConstructor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import com.shev8987.spring.demo.services.hbase.entities.TableEntity;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class HbaseRepositoryImpl implements HbaseRepository {

    private final HBaseConfig hBaseConfig;


    @Override
    public void createTable(TableEntity table) throws IOException {

        Connection connection = hBaseConfig.getConnection(hBaseConfig.composeHbaseConfig());
        Admin admin = connection.getAdmin();


        TableName tableName = TableName.valueOf(table.getTable());

        if (admin.tableExists(tableName)) {

            return;
        }


        TableDescriptorBuilder tableDescriptorBuilder = TableDescriptorBuilder
                .newBuilder(tableName);

        Collection<ColumnFamilyDescriptor> families = new ArrayList<>();

        for (var rowKey : table.getRowKey()) {

            // Формируем объект вставки
            Put thePut = new Put(Bytes.toBytes(rowKey.getRowKeyName()));


            for (var columnFamily : rowKey.getColumnFamily()) {

                ColumnFamilyDescriptor columnFamilyDescriptor = ColumnFamilyDescriptorBuilder.of(columnFamily.getName());

                var bytesColumnFamily = Bytes.toBytes(columnFamily.getName());

                for (var column : columnFamily.getColumns().entrySet()) {

                    var bytesQualifier = Bytes.toBytes(column.getKey());
                    var value = Bytes.toBytes(column.getValue());

                    thePut.addColumn(bytesColumnFamily, bytesQualifier, value);

                }

                families.add(columnFamilyDescriptor);

            }
        }

        tableDescriptorBuilder.setColumnFamilies(families);

        admin.createTable(tableDescriptorBuilder.build());

    }

    @Override
    public void getById() throws IOException {

        Connection connection = hBaseConfig.getConnection(hBaseConfig.composeHbaseConfig());
        Admin admin = connection.getAdmin();

    }

    @Override
    public void getAll() throws IOException {

        Connection connection = hBaseConfig.getConnection(hBaseConfig.composeHbaseConfig());
        Admin admin = connection.getAdmin();

    }

    @Override
    public void update(TableEntity table) throws IOException {

        Connection connection = hBaseConfig.getConnection(hBaseConfig.composeHbaseConfig());
        Admin admin = connection.getAdmin();

    }

    @Override
    public void delete() throws IOException {

        Connection connection = hBaseConfig.getConnection(hBaseConfig.composeHbaseConfig());
        Admin admin = connection.getAdmin();

    }
}
