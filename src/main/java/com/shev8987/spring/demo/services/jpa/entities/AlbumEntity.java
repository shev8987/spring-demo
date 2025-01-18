package com.shev8987.spring.demo.services.jpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Getter
@Setter
@Entity
@Table(name = "album")
@NoArgsConstructor
@AllArgsConstructor
public class AlbumEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_album_seq")
    @SequenceGenerator(name = "seq_album_seq", sequenceName = "seq_album", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "singer_id", insertable = false, updatable = false)
    @JsonIgnore
    private SingerEntity singer;

}
