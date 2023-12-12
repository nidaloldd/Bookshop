package org.example.model;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Book {

    private @NonNull Long id;
    private @NonNull String title;
    private @NonNull  String author;
    private @NonNull Genre genre;
    private @NonNull double price;
    private String imageSource;


    public Book(@NonNull Long id, @NonNull String title, @NonNull String author, @NonNull Genre genre, @NonNull double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.imageSource = "https://placekitten.com/300/400";
    }
    public Book(@NonNull Long id, @NonNull String title, @NonNull String author, @NonNull Genre genre, @NonNull double price,String imageSource) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.imageSource = imageSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        final Book book = (Book) o;
        return Objects.equals(id, book.id)
                && Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && genre == book.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, genre);
    }

    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", author=" + author
                + ", genre=" + genre
                + '}';
    }

}
