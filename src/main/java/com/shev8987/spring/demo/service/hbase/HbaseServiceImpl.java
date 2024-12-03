package com.shev8987.spring.demo.service.hbase;

import com.shev8987.spring.demo.dto.TableRequestDto;
import com.shev8987.spring.demo.mapper.HBaseMapper;
import com.shev8987.spring.demo.repository.hbase.HbaseRepository;
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
