package com.shev8987.spring.demo.services.hbase.service;


import com.shev8987.spring.demo.dto.hbase.TableRequestDto;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface HbaseService {

    void createTable(TableRequestDto dto);

    void getById() throws IOException;

    void getAll() throws IOException;

    void update(TableRequestDto dto);

    void delete() throws IOException;

}
