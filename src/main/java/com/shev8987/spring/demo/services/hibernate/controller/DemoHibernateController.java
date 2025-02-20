package com.shev8987.spring.demo.services.hibernate.controller;

import com.shev8987.spring.demo.services.entities.SingerEntity;
import com.shev8987.spring.demo.services.hibernate.service.HibernateService;
import com.shev8987.spring.demo.services.jpa.service.JPAService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/demo/hibernate")
@RequiredArgsConstructor
public class DemoHibernateController {

    private final HibernateService hibernateService;

    @GetMapping("singers")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    List<SingerEntity> getSingerList() {

       return hibernateService.getSingerFullList();
    }

    @GetMapping("singer")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    SingerEntity getSingerById(Long id) {

        return hibernateService.getSingerById(id);
    }


    @PostMapping("save/singer")
    @PreAuthorize("hasRole('ADMIN')")
    void saveSinger(@RequestBody SingerEntity singer) {
        hibernateService.save(singer);
    }


    @GetMapping("delete/singer/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void deleteSinger(@PathVariable Long id) {
        hibernateService.deleteSinger(id);
    }
}
