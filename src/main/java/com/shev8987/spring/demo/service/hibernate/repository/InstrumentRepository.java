package com.shev8987.spring.demo.service.hibernate.repository;

import com.shev8987.spring.demo.service.hibernate.entities.AlbumEntity;
import com.shev8987.spring.demo.service.hibernate.entities.InstrumentEntity;
import com.shev8987.spring.demo.service.hibernate.entities.SingerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstrumentRepository extends JpaRepository<InstrumentEntity, Long> {

    @Override
    List<InstrumentEntity> findAll();

    @Override
    Optional<InstrumentEntity> findById(Long id);
}
