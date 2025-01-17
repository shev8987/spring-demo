package com.shev8987.spring.demo.services.hibernate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shev8987.spring.demo.services.hibernate.entities.SingerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class AlbumDto {

    private Long id;

    private String title;

    private LocalDate releaseDate;

    private Integer version;

    public AlbumDto(Long id, String title, LocalDate releaseDate, Integer version) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.version = version;
    }
}
