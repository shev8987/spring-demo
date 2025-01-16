package com.shev8987.spring.demo.services.hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "instrument")
@Data
public class InstrumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_instrument")
    @SequenceGenerator(name = "seq_instrument", sequenceName = "seq_instrument", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "instrument_name", nullable = false)
    private String instrumentName;

    @ManyToMany
    @JoinTable(name = "singer_instrument",
    joinColumns = @JoinColumn(name = "instrument_id"),
    inverseJoinColumns = @JoinColumn(name = "singer_id"))
    private Set<SingerEntity> singerEntities;
}
