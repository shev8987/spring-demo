package com.shev8987.spring.demo.services.jpa.dto;

import com.shev8987.spring.demo.services.jpa.entities.SingerEntity;
import lombok.Data;

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
