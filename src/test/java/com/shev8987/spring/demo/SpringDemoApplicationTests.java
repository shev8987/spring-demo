package com.shev8987.spring.demo;

import com.shev8987.spring.demo.services.hbase.dto.TableRequestDto;
import com.shev8987.spring.demo.services.hbase.entities.ColumnFamilyEntity;
import com.shev8987.spring.demo.services.hbase.entities.RowKeyEntity;
import com.shev8987.spring.demo.services.hbase.service.HbaseService;
import com.shev8987.spring.demo.services.jpa.service.JPAService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDemoApplicationTests {

    @Autowired
    private JPAService jpaService;

    @Autowired
    private HbaseService hbaseService;

    @Test
    void checkSingerList() {

        var singerList = jpaService.getSingerFullList();
    }

    @Test
    void checkSingerById() {

        var singer = jpaService.getSingerById(1L);
    }

    @Test
    void checkHbaseCreateTable() {

        var req =TableRequestDto
                .builder()
                .table("test1")
                .rowKey(List.of(RowKeyEntity
                        .builder()
                        .rowKeyName("row1")
                        .columnFamily(List.of(
                                ColumnFamilyEntity
                                        .builder()
                                        .name("row1colums")
                                        .columns(Map.of("col1", "value1",
                                                "col2", "value2"))
                                        .build()
                        ))

                        .build()
                        )
                )
                .build();

       var table = hbaseService.createTable(req);
       hbaseService.addColumns(req);

       log.info("created table: {}", table);
    }

    @Test
    void checkHbaseAddColumnTable() {

        var req =TableRequestDto
                .builder()
                .table("test")
                .rowKey(List.of(RowKeyEntity
                                .builder()
                                .rowKeyName("row1")
                                .columnFamily(List.of(
                                        ColumnFamilyEntity
                                                .builder()
                                                .name("row1colums")
                                                .columns(Map.of("col1", "value1",
                                                        "col2", "value2"))
                                                .build()
                                ))

                                .build()
                        )
                )
                .build();

        hbaseService.addColumns(req);

        var result = hbaseService.getAll("test", "row1", "row1colums");

    }

    @Test
    void checkHbaseGetTableValues() {

       var result = hbaseService.getAll("test", "row1", "row1colums");

    }

}
