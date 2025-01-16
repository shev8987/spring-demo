package com.shev8987.spring.demo.services.hibernate.repository;

import com.shev8987.spring.demo.services.hibernate.entities.SingerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SingerRepository extends JpaRepository<SingerEntity, Long> {

    @Override
    List<SingerEntity> findAll();

    @Override
    Optional<SingerEntity> findById(Long id);
}
