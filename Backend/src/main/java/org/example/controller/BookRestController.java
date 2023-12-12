package org.example.controller;

import org.example.model.Book;
import org.example.model.exeption.NotFoundException;
import org.example.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllRolePlays() {
        return bookService.getAllBooks();
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
