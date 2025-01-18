package com.shev8987.spring.demo.services.jpa.dto;

import com.shev8987.spring.demo.services.jpa.entities.SingerEntity;
import lombok.Data;

@Data
public class InstrumentDto {

    private Long id;

    private String instrumentName;

    public InstrumentDto(Long id, String instrumentName) {
        this.id = id;
        this.instrumentName = instrumentName;
    }
}
