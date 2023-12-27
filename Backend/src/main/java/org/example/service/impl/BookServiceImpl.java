package org.example.service.impl;

import lombok.extern.java.Log;
import org.example.model.Book;
import org.example.model.Genre;
import org.example.model.exeption.NotFoundException;
import org.example.repo.BookRepository;
import org.example.repo.GenreRepository;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final List<Book> dataBase = new ArrayList<>();
    private BookRepository bookRepository;
    private GenreRepository genreRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository,GenreRepository genreRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    @Override
    public List<String> getAllGenresForBook(Long bookId) {
        return bookRepository.getListOfGenres(bookId);
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Book createBook(Book rolePlay) {
        bookRepository.save(rolePlay);
        return rolePlay;
    }

    @Override
    public Book updateBook(Long id, Book rolePlayChange) {
        final Book book = getBook(id);
        book.setTitle(rolePlayChange.getTitle());
        book.setGenres(rolePlayChange.getGenres());
        book.setAuthor(rolePlayChange.getAuthor());
        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteBook(Long id) {
        final Book book = getBook(id);
        bookRepository.delete(book);
    }

}
