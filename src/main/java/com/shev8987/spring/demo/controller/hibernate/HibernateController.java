package com.shev8987.spring.demo.controller.hibernate;

import com.shev8987.spring.demo.services.hbase.service.HbaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hibernate")
@RequiredArgsConstructor
public class HibernateController {

    private final HbaseService hbaseService;

}
