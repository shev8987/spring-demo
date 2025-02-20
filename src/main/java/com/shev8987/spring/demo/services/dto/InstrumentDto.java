package com.shev8987.spring.demo.services.dto;

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
