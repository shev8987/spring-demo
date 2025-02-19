package com.shev8987.spring.demo.services.jpa.controller;

import com.shev8987.spring.demo.services.jpa.dto.SingerDto;
import com.shev8987.spring.demo.services.jpa.entities.SingerEntity;
import com.shev8987.spring.demo.services.jpa.service.JPAService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/demo")
@RequiredArgsConstructor
public class DemoJPAController {

    private final  JPAService jpaService;

    @GetMapping("singers")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    List<SingerEntity> getSingerList() {

       return jpaService.getSingerFullList();
    }

    @GetMapping("singer")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    SingerEntity getSingerById(Long id) {

        return jpaService.getSingerById(id);
    }

    @PostMapping("save/singer")
    @PreAuthorize("hasRole('ADMIN')")
    void saveSinger(@RequestBody SingerEntity singer) {
        jpaService.save(singer);
    }


    @GetMapping("delete/singer/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    void deleteSinger(@PathVariable Long id) {
        jpaService.deleteSinger(id);
    }
}
