package org.example.repo;

import org.example.model.Book;
import org.example.model.Genre;
import org.example.model.GenreType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
    Genre findByGenreType(GenreType genreType);
}
