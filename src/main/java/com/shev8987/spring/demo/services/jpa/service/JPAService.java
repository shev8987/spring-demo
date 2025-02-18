package com.shev8987.spring.demo.services.jpa.service;

import com.shev8987.spring.demo.services.jpa.entities.SingerEntity;
import com.shev8987.spring.demo.services.jpa.repository.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JPAService {

    private final SingerRepository singerRepository;

    @Transactional(readOnly = true)
    public List<SingerEntity> getSingerFullList() {

       return  singerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public SingerEntity getSingerById(Long id) {

        return singerRepository.findById(id).get();

    }
}
