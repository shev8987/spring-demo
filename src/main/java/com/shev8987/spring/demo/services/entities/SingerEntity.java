package com.shev8987.spring.demo.services.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "singer")
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "SingerEntity.albums", attributeNodes = @NamedAttributeNode("albums"))
public class SingerEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_singer_seq")
    @SequenceGenerator(name = "seq_singer_seq", sequenceName = "seq_singer", allocationSize = 1)
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

    @OneToMany(mappedBy = "singer", cascade = jakarta.persistence.CascadeType.ALL)
    private List<AlbumEntity> albums;

    @ManyToMany
    @JoinTable(name = "singer_instrument", joinColumns = @JoinColumn(name = "singer_id"),
            inverseJoinColumns = @JoinColumn(name = "instrument_id"))
    private List<InstrumentEntity> instruments;


    public boolean addAlbum(AlbumEntity album) {
        album.setSinger(this);
        return getAlbums().add(album);
    }

    public void removeAlbum(AlbumEntity album) {
        getAlbums().remove(album);
    }
}
