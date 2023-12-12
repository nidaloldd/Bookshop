package org.example.controller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController {
    private static final String Book_LIST_TEMPLATE_NAME = "book/list";

    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getAllRolePlay(final Model model) {
        final List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return Book_LIST_TEMPLATE_NAME;
    }
}
