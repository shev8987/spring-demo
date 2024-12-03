package com.shev8987.spring.demo.repository.hbase;

import com.shev8987.spring.demo.model.hbase.TableEntity;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public interface HbaseRepository {

    void createTable(TableEntity table) throws IOException;

    void getById() throws IOException;

    void getAll() throws IOException;

    void update(TableEntity table) throws IOException;

    void delete() throws IOException;
}
