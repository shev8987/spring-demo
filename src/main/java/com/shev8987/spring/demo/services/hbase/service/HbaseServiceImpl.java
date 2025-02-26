package com.shev8987.spring.demo.services.hbase.service;


import com.shev8987.spring.demo.services.hbase.dto.TableRequestDto;
import com.shev8987.spring.demo.services.hbase.mapper.HBaseMapper;
import com.shev8987.spring.demo.services.hbase.repository.HbaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.hadoop.hbase.client.Table;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class HbaseServiceImpl implements HbaseService {

    private final HbaseRepository repository;

    @Override
    public Table createTable(TableRequestDto dto) {

        var entity = HBaseMapper.MAPPER.toEntity(dto);
        return repository.createTable(entity);
    }

    @Override
    public void addColumns(TableRequestDto dto) {
        var entity = HBaseMapper.MAPPER.toEntity(dto);
        repository.addColumns(entity);
    }

    @Override
    public void getById() {

    }

    @Override
    public Map<String, String> getAll(String tableName, String rowKey, String columnFamily) {

      return repository.getAll(tableName, rowKey, columnFamily);

    }

    @Override
    public void update(TableRequestDto dto) {

    }

    @Override
    public void delete() {

    }
}
