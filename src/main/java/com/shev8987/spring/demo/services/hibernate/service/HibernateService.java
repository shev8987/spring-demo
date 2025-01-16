package com.shev8987.spring.demo.services.hibernate.service;

import com.shev8987.spring.demo.services.hibernate.entities.SingerEntity;
import com.shev8987.spring.demo.services.hibernate.repository.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HibernateService {

    private final SingerRepository singerRepository;

    public List<SingerEntity> getSingerList() {

       return singerRepository.findAll();
    }
}
