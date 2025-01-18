package com.shev8987.spring.demo.services.jpa.repository;

import com.shev8987.spring.demo.services.jpa.dto.SingerDto;
import com.shev8987.spring.demo.services.jpa.entities.AlbumEntity;
import com.shev8987.spring.demo.services.jpa.entities.InstrumentEntity;
import com.shev8987.spring.demo.services.jpa.entities.SingerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SingerRepository extends JpaRepository<SingerEntity, Long> {

}
