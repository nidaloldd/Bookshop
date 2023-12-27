package org.example.model;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private  Long id;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_genres",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "genres_id")
    )
    private Set<Genre> genres = new HashSet<>();
    @NonNull
    private double price;
    @Getter @Setter
    private String imageSource;

    public Book(@NonNull Long id, @NonNull String title, @NonNull String author, @NonNull double price, String imageSource ,@NonNull Genre... genres) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genres = convertArrayToSet(genres);
        this.price = price;
        this.imageSource = imageSource;
    }

    public Book(@NonNull Long id, @NonNull String title, @NonNull String author,@NonNull double price ,@NonNull Genre... genres) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genres = convertArrayToSet(genres);
        this.price = price;
        this.imageSource = "https://placekitten.com/300/400";
    }
    private static <T> Set<T> convertArrayToSet(T array[]) {
        return Arrays.stream(array).collect(
                Collectors.toSet());
    }

}
