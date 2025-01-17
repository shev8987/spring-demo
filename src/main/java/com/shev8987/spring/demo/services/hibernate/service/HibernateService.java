package com.shev8987.spring.demo.services.hibernate.service;

import com.shev8987.spring.demo.services.hibernate.entities.SingerEntity;
import com.shev8987.spring.demo.services.hibernate.repository.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HibernateService {

    private final SingerRepository singerRepository;

    @Transactional(readOnly = true)
    public List<SingerEntity> getSingerById() {

       var a = singerRepository.findAll();

       return new ArrayList<>();
    }

    @Transactional(readOnly = true)
    public SingerEntity getSingerById(Long id) {

        var a = singerRepository.findById(id);

        return a.get();
    }
}
