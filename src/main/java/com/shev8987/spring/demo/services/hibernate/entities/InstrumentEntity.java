package com.shev8987.spring.demo.services.hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "instrument")
@Getter
@Setter
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
    private List<SingerEntity> singerEntities;
}
