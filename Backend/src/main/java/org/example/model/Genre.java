package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    @JsonManagedReference
    private GenreType genreType;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books = new HashSet<>();
    public Genre(GenreType genreType) {
        this.genreType = genreType;
    }
    public Genre(){}
}
