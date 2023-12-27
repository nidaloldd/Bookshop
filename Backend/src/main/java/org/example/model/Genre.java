package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private GenreType genreType;

    public Genre(GenreType genreType) {
        this.genreType = genreType;
    }
    public Genre(){}
}
