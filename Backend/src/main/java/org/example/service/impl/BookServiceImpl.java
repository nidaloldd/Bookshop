package org.example.service.impl;

import org.example.model.Book;
import org.example.model.Genre;
import org.example.model.exeption.NotFoundException;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final List<Book> dataBase = new ArrayList<>();

    @Autowired
    public BookServiceImpl() {
        dataBase.add(new Book(1L, "Whispers of the Forgotten", "Samantha Evergreen", Genre.FANTASY, 10d));
        dataBase.add(new Book(2L, "Shadows in the Starlight", "Jonathan Nightshade", Genre.SCI_FI, 23d));
        dataBase.add(new Book(3L, "Ephemeral Echoes", "Isabella Rivers", Genre.MYSTERY,8.3d, "https://placekitten.com/g/200/300"));
        dataBase.add(new Book(4L, "Chronicles of the Celestial Realm", "Alexander Skyweaver", Genre.FANTASY,2.5d));
        dataBase.add(new Book(5L, "Midnight Mirage", "Olivia Moonstone", Genre.ROMANCE,2.5d));
        dataBase.add(new Book(6L, "Quantum Quandaries", "Maxwell Quantum", Genre.SCI_FI,1.5d));
        dataBase.add(new Book(7L, "Enigma of the Sapphire Scroll", "Victoria Starchaser", Genre.HISTORICAL_FICTION,2.5d,"https://placekitten.com/g/300/400"));
        dataBase.add(new Book(8L, "Labyrinth of Illusions", "Cassandra Shadowborn", Genre.HORROR,2.5d));
        dataBase.add(new Book(9L, "Serenade of the Cosmic Symphony", "Celeste Stardust", Genre.SCI_FI,2.5d,"https://placekitten.com/400/500"));
        dataBase.add(new Book(10L, "Harmony's Embrace", "Gabriel Melody", Genre.ROMANCE,2.2d));
        dataBase.add(new Book(11L, "Infinite Improbability", "Douglas Galaxy", Genre.HUMOR,3.99d,"https://placekitten.com/g/400/500"));
    }

    @Override
    public List<Book> getAllBooks() {
        return dataBase;
    }

    @Override
    public Book getBook(Long id) {
        return dataBase.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Book createBook(Book rolePlay) {
        rolePlay.setId(getNextId());
        dataBase.add(rolePlay);
        return rolePlay;
    }

    @Override
    public Book updateBook(Long id, Book rolePlayChange) {
        final Book book = getBook(id);
        book.setTitle(rolePlayChange.getTitle());
        book.setGenre(rolePlayChange.getGenre());
        book.setAuthor(rolePlayChange.getAuthor());
        return book;
    }

    @Override
    public void deleteBook(Long id) {
        final Book book = getBook(id);
        dataBase.remove(book);
    }

    private long getNextId() {
        return getLastId() + 1L;
    }

    private long getLastId() {
        return dataBase.stream()
                .mapToLong(Book::getId)
                .max()
                .orElse(0);
    }
}
