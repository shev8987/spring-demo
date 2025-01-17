package com.shev8987.spring.demo.services.hibernate.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.shev8987.spring.demo.services.hibernate.entities.AlbumEntity;
import com.shev8987.spring.demo.services.hibernate.entities.InstrumentEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
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
