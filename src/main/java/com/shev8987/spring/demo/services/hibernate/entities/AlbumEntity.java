package com.shev8987.spring.demo.services.hibernate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "album")
@Getter
@Setter
public class AlbumEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_album")
    @SequenceGenerator(name = "seq_album", sequenceName = "seq_album", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "singer_id", nullable = false)
    private Long singerId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    //@ManyToOne
   // @JoinColumn(name = "singer_id")
   // @JsonIgnore
    //private SingerEntity singerEntity;

}
