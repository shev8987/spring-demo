package com.shev8987.spring.demo.services.hibernate.repository;

import com.shev8987.spring.demo.services.hibernate.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

    @Override
    List<AlbumEntity> findAll();

    @Override
    Optional<AlbumEntity> findById(Long id);
}
