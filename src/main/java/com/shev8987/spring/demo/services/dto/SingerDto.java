package com.shev8987.spring.demo.services.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SingerDto {

    private Long id;

    @NotBlank(message = "firstName обязательно")
    private String firstName;

    @NotBlank(message = "lastName обязательно")
    private String lastName;

    private LocalDate birthDate;

    @NotNull(message = "version обязательно")
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
