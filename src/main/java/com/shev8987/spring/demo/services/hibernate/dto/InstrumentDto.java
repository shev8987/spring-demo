package com.shev8987.spring.demo.services.hibernate.dto;

import com.shev8987.spring.demo.services.hibernate.entities.SingerEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
public class InstrumentDto {

    private Long id;

    private String instrumentName;

    public InstrumentDto(Long id, String instrumentName) {
        this.id = id;
        this.instrumentName = instrumentName;
    }
}
