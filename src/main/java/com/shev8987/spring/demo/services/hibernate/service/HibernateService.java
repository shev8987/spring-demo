package com.shev8987.spring.demo.services.hibernate.service;

import com.shev8987.spring.demo.services.hibernate.entities.SingerEntity;
import com.shev8987.spring.demo.services.hibernate.repository.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HibernateService {

    private final SingerRepository singerRepository;

    @Transactional(readOnly = true)
    public List<SingerEntity> getSingerList() {

        return  singerRepository.getSingerList();
    }
}
