package com.shev8987.spring.demo.services.hbase.repository;

import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import com.shev8987.spring.demo.services.hbase.entities.TableEntity;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Repository
public class HbaseRepositoryImpl implements HbaseRepository {

    public static final String HBASE_ZOOKEEPER_QUORUM_PARAM = "hbase.zookeeper.quorum";
    public static final String ZOOKEEPER_ZNODE_PARENT_PARAM = "zookeeper.znode.parent";

    public Configuration composeHbaseConfig() {
        // Конфиг org.apache.hadoop.conf.Configuration
        Configuration config = HBaseConfiguration.create();
        config.set(HBASE_ZOOKEEPER_QUORUM_PARAM, "localhost");
        config.set(ZOOKEEPER_ZNODE_PARENT_PARAM, "/hbase");

        return config;
    }

    public Connection getConnection(Configuration config) throws IOException {

        try {
            HBaseAdmin.available(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ConnectionFactory.createConnection(config);
    }

    @Override
    public Table createTable(TableEntity table) {

        try {
            Connection connection = getConnection(composeHbaseConfig());
            Admin admin = connection.getAdmin();

            TableName tableName = TableName.valueOf(table.getTable());

            if (admin.tableExists(tableName)) {
                return connection.getTable(tableName);
            }

            TableDescriptorBuilder tableDescriptorBuilder = TableDescriptorBuilder
                    .newBuilder(tableName);


            Collection<ColumnFamilyDescriptor> families = new ArrayList<>();

            for (var rowKey : table.getRowKey()) {

                // Формируем объект вставки
                for (var columnFamily : rowKey.getColumnFamily()) {

                    ColumnFamilyDescriptor columnFamilyDescriptor = ColumnFamilyDescriptorBuilder.of(columnFamily.getName());
                    families.add(columnFamilyDescriptor);

                }
            }

            tableDescriptorBuilder.setColumnFamilies(families);
            admin.createTable(tableDescriptorBuilder.build());

            return connection.getTable(tableName);
        } catch (Exception e) {

            return null;
        }

    }

    @Override
    public void addColumns(TableEntity entity){

        try {
            Connection connection = getConnection(composeHbaseConfig());
            Admin admin = connection.getAdmin();

            TableName tableName = TableName.valueOf(entity.getTable());

            if (!admin.tableExists(tableName)) {
                log.info("Таблица не найдена {} ", entity.getTable());
                return;
            }

            Table t1 = connection.getTable(tableName);

            for (var rowKey : entity.getRowKey()) {

                log.info("Формируем объект вставки для rowKey: {} ", rowKey.getRowKeyName());
                for (var columnFamily : rowKey.getColumnFamily()) {

                    log.info("  => columnFamily: {} ", columnFamily.getName());
                    var bytesColumnFamily = Bytes.toBytes(columnFamily.getName());

                    for (var column : columnFamily.getColumns().entrySet()) {

                        Put thePut = new Put(Bytes.toBytes(rowKey.getRowKeyName()));
                        var bytesQualifier = Bytes.toBytes(column.getKey());
                        var value = Bytes.toBytes(column.getValue());

                        thePut.addColumn(bytesColumnFamily, bytesQualifier, value);
                        t1.put(thePut);

                    }

                }
            }

        } catch (Exception e) {

        }

    }

    @Override
    public void getById(String tableName, String rowKey, String columnFamily, String column) {

        try {
            Connection connection = getConnection(composeHbaseConfig());
            Admin admin = connection.getAdmin();

            TableName table = TableName.valueOf(tableName);

            if (!admin.tableExists(table)) {
                return;
            }

        } catch (Exception e) {

        }


    }

    @Override
    public Map<String, String> getAll(String tableName, String rowKey, String columnFamily) {

        try {
            Connection connection = getConnection(composeHbaseConfig());
            Admin admin = connection.getAdmin();
            admin.listTableDescriptors().forEach(System.out::println); // список таблиц

            TableName table = TableName.valueOf(tableName);

            if (!admin.tableExists(table)) {
                return null;
            }

            Table t = connection.getTable(table);
            //Get
            Get theGet = new Get(Bytes.toBytes(rowKey));
            Result result = t.get(theGet);

            // loop for result
            for (Cell cell : result.listCells()) {
                String qualifier = Bytes.toString(CellUtil.cloneQualifier(cell));
                String value = Bytes.toString(CellUtil.cloneValue(cell));
                log.info("Qualifier : {} : Value : {}", qualifier, value);
            }

            //create Map by result and print it
            Map<String, String> getResult = result.listCells().stream().collect(Collectors.toMap(e -> Bytes.toString(CellUtil.cloneQualifier(e)), e -> Bytes.toString(CellUtil.cloneValue(e))));
            getResult.entrySet().stream().forEach(e -> log.info("Qualifier : {} : Value : {}", e.getKey(), e.getValue()));

            System.out.println("---------Scan---------");
            Scan scan = new Scan();
            ResultScanner resultScan = t.getScanner(scan);
            resultScan.forEach(e -> {
                System.out.printf("Row \"%s\"%n", Bytes.toString(e.getRow()));
                Map<String, String> getResultScan = e.listCells().stream().collect(Collectors.toMap(d -> Bytes.toString(CellUtil.cloneQualifier(d)), d -> Bytes.toString(CellUtil.cloneValue(d))));
                getResultScan.entrySet().stream().forEach(d -> System.out.printf("column \"%s\", value \"%s\"%n", d.getKey(), d.getValue()));
                System.out.println();
            });

            return getResult;

        } catch (Exception e) {

            return null;
        }
    }

    @Override
    public void update(TableEntity newEntity) {

        try {
            Connection connection = getConnection(composeHbaseConfig());
            Admin admin = connection.getAdmin();
            admin.listTableDescriptors().forEach(System.out::println); // список таблиц

            TableName tableName = TableName.valueOf(newEntity.getTable());

            if (!admin.tableExists(tableName)) {

                return;
            }


            var table = connection.getTable(tableName);
        } catch (Exception e) {

        }


    }

    @Override
    public void delete(String tableName) {

        try {
            Connection connection = getConnection(composeHbaseConfig());
            Admin admin = connection.getAdmin();
            admin.listTableDescriptors().forEach(System.out::println); // список таблиц

            TableName table = TableName.valueOf(tableName);

            if (!admin.tableExists(table)) {

                return;
            }

            admin.deleteTable(table);
            admin.listTableDescriptors().forEach(System.out::println); // список таблиц


        } catch (Exception e) {

        }

    }
}
