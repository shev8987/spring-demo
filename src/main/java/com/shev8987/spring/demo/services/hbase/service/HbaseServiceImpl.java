package com.shev8987.spring.demo.services.hbase.service;

import com.shev8987.spring.demo.dto.hbase.TableRequestDto;
import com.shev8987.spring.demo.services.hbase.mapper.HBaseMapper;
import com.shev8987.spring.demo.services.hbase.repository.HbaseRepository;
import lombok.RequiredArgsConstructor;

import java.io.IOException;


@RequiredArgsConstructor
public class HbaseServiceImpl implements HbaseService {

    private final HbaseRepository repository;
    private final HBaseMapper mapper;

    @Override
    public void createTable(TableRequestDto dto) {

    }

    @Override
    public void getById() throws IOException {

    }

    @Override
    public void getAll() throws IOException {

    }

    @Override
    public void update(TableRequestDto dto) {

    }

    @Override
    public void delete() throws IOException {

    }
}
