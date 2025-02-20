package com.shev8987.spring.demo.services.jpa.repository;


import com.shev8987.spring.demo.services.entities.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, Long> {

}
