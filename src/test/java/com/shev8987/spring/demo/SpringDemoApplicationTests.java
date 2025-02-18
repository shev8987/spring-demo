package com.shev8987.spring.demo;

import com.shev8987.spring.demo.services.jpa.service.JPAService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDemoApplicationTests {

    @Autowired
    private JPAService jpaService;

    @Test
    void checkSingerList() {

        var singerList = jpaService.getSingerFullList();
    }

    @Test
    void checkSingerById() {

        var singer = jpaService.getSingerById(1L);
    }

}
