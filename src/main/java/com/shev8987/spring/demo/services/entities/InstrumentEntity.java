package com.shev8987.spring.demo.services.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.List;

@Builder
@Entity
@Table(name = "instrument")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InstrumentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_instrument_seq")
    @SequenceGenerator(name = "seq_instrument_seq", sequenceName = "seq_instrument", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "instrument_name", nullable = false)
    private String instrumentName;

    @ManyToMany
    @JoinTable(name = "singer_instrument",
    joinColumns = @JoinColumn(name = "instrument_id"),
    inverseJoinColumns = @JoinColumn(name = "singer_id"))
    @JsonIgnore
    private List<SingerEntity> singerEntities;
}
