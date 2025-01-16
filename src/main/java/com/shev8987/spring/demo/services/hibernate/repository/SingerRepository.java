package com.shev8987.spring.demo.services.hibernate.repository;

import com.shev8987.spring.demo.services.hibernate.entities.SingerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerRepository extends JpaRepository<SingerEntity, Long> {

    @Query("SELECT '*' FROM SingerEntity s")
    List<SingerEntity> getSingerList();
}
