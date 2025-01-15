package com.shev8987.spring.demo.controller;

import com.shev8987.spring.demo.service.hbase.HbaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController("/hibernate")
@RequiredArgsConstructor
public class HibernateController {

    private final HbaseService hbaseService;

}
