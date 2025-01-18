package com.shev8987.spring.demo.services.jpa.dto;

import com.shev8987.spring.demo.services.jpa.entities.AlbumEntity;
import com.shev8987.spring.demo.services.jpa.entities.InstrumentEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SingerDto {

    private Long id;

    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private Integer version;

    private List<AlbumDto> albums;

    private List<InstrumentDto> instruments;

    public SingerDto(Long id, String firstName, String lastName , Integer version) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.version = version;
    }
}
