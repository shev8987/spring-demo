package com.shev8987.spring.demo.services.hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "instrument")
@Data
public class InstrumentEntity implements Serializable {

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
    private List<SingerEntity> singerEntities;
}
