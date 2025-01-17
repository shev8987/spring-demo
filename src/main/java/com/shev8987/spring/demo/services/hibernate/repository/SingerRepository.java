package com.shev8987.spring.demo.services.hibernate.repository;

import com.shev8987.spring.demo.services.hibernate.dto.SingerDto;
import com.shev8987.spring.demo.services.hibernate.entities.AlbumEntity;
import com.shev8987.spring.demo.services.hibernate.entities.SingerEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerRepository extends JpaRepository<SingerEntity, Long> {

    //@EntityGraph(value = "SingerEntity.albums")
    //SingerEntity getSingerEntityById(Long id);

    @Query("select new com.shev8987.spring.demo.services.hibernate.dto.SingerDto(s.id, s.firstName, s.lastName, s.version) " +
            "from SingerEntity s")
    List<SingerDto> getAllById(Long id);

}
