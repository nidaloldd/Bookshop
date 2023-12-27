package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Book;
import org.example.model.exeption.NotFoundException;
import org.example.service.BookService;
import org.example.service.impl.ImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class BookRestController {

    private final BookService bookService;
    private final ImageService imageService;

    public BookRestController(final BookService bookService,final ImageService imageService) {
        this.bookService = bookService;
        this.imageService = imageService;
    }

    @GetMapping
    public List<Book> getAllRolePlays() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getGenres/{bookId}")
    public List<String> getAllGenresToBook(final @PathVariable Long bookId) {
        return bookService.getAllGenresForBook(bookId);
    }

    @GetMapping("/{id}")
    Book getBook(final @PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping
    Book createRolePlay(final @RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    Book updateRolePlay(final @PathVariable Long id, final @RequestBody Book bookChange) {
        return bookService.updateBook(id, bookChange);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRolePlay(final @PathVariable Long id) {
        try {
            bookService.deleteBook(id);
        } catch (NotFoundException e) {
            // Ignored
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
