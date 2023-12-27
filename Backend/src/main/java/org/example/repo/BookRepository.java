package org.example.repo;

import org.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book,Long> {

    @Query(value = "select genre_type\n" +
            "from genres\n" +
            "inner join book_genres\n" +
            "on genres_id = id\n" +
            "where book_id like :bookId", nativeQuery = true)
    List<String> getListOfGenres(@Param("bookId") Long bookId);
}
