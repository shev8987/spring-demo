package com.shev8987.spring.demo;

import com.shev8987.spring.demo.services.hibernate.service.HibernateService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDemoApplicationTests {

    @Autowired
    private HibernateService hibernateService;

    @Test
    void checkSingerList(){

        var singerList = hibernateService.getSingerList();

    }

}
