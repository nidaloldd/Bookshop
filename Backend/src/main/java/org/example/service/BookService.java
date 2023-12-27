package org.example.service;

import org.example.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBook(Long id);

    Book createBook(Book rolePlay);

    Book updateBook(Long id, Book rolePlayChange);

    void deleteBook(Long id);
    public List<String> getAllGenresForBook(Long bookId);
}
