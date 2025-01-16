package com.shev8987.spring.demo.services.hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "singer")
@Getter
@Setter
public class SingerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_singer")
    @SequenceGenerator(name = "seq_singer", sequenceName = "seq_singer", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    //@OneToMany(mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
   // private Set<AlbumEntity> albums;

    //@ManyToMany
  //  @JoinTable(name = "singer_instrument", joinColumns = @JoinColumn(name = "singer_id"),
  //  inverseJoinColumns = @JoinColumn(name = "instrument_id"))
   // private Set<InstrumentEntity> instruments;

}
