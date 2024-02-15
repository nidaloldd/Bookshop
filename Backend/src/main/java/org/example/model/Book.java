package org.example.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
@Component
@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private  Long id;
    @NonNull
    private String title;
    @NonNull
    private String author;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "book_genres",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") }
    )
    private Set<Genre> genres = new HashSet<>();


    @NonNull
    private double price;

    public Book(@NonNull Long id, @NonNull String title, @NonNull String author,@NonNull double price ,@NonNull Genre... genres) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genres = convertArrayToSet(genres);
        this.price = price;
    }
    private static <T> Set<T> convertArrayToSet(T array[]) {
        return Arrays.stream(array).collect(
                Collectors.toSet());
    }

}
