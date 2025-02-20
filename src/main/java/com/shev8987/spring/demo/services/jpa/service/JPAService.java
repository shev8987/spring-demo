package com.shev8987.spring.demo.services.jpa.service;


import com.shev8987.spring.demo.services.entities.SingerEntity;
import com.shev8987.spring.demo.services.jpa.repository.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class JPAService {

    private final SingerRepository singerRepository;

    @Transactional(readOnly = true)
    public List<SingerEntity> getSingerFullList() {

        return singerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public SingerEntity getSingerById(Long id) {

        return singerRepository.findById(id).get();

    }

    @Transactional
    public void save(SingerEntity singerEntity) {

        if (Objects.isNull(singerEntity.getId())) {
            singerRepository.saveAndFlush(singerEntity);
        } else {
            var oldEntity = singerRepository.findById(singerEntity.getId()).get();
            if (Objects.isNull(oldEntity)) {
                return;
            }
            singerEntity.setId(oldEntity.getId());
            singerRepository.saveAndFlush(singerEntity);
        }

    }

    @Transactional
    public void deleteSinger(Long id) {

        var entity = singerRepository.findById(id);
        if (entity.isEmpty()) {
            return;
        }

        singerRepository.delete(entity.get());
    }

}
