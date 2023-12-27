package org.example.populator.imp;

import lombok.extern.slf4j.Slf4j;
import org.example.model.Book;
import org.example.model.Genre;
import org.example.model.GenreType;
import org.example.populator.DBPopulator;
import org.example.repo.BookRepository;
import org.example.repo.GenreRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class BookPopulator implements DBPopulator {

    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    public BookPopulator(BookRepository bookRepository, GenreRepository genreRepository) {

        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public void populateDatabase() {
        bookRepository.deleteAll(bookRepository.findAll());
        genreRepository.deleteAll(genreRepository.findAll());

        populateGenre();
        populateBook();
    }
    private void populateBook() {
        log.info("Initialize Book...");

        bookRepository.save(new Book(
                1L,
                "The Forgotten Library: Chronicles of Lost Lore",
                "Jackson Blackthorn",
                12d,
                "static/img/bookCovers/1.jpg",
                genreRepository.findByGenreType(GenreType.FANTASY),
                genreRepository.findByGenreType(GenreType.MYSTERY),
                genreRepository.findByGenreType(GenreType.ADVENTURE)
        ));

        bookRepository.save(new Book(
                2L,
                "Digital Enigmas: Unveiling the Web's Darkside",
                "Elara Nightshade",
                14d,
                genreRepository.findByGenreType(GenreType.THRILLER),
                genreRepository.findByGenreType(GenreType.MYSTERY)

        ));
        bookRepository.save(new Book(
                3L,
                "The Magical Cipher: Artistry of Programming",
                "Maxwell Steele",
                11d,
                genreRepository.findByGenreType(GenreType.SCI_FI)
        ));
        bookRepository.save(new Book(
                4L,
                "Hidden Dimensions: Decoding the Quantum Realm",
                "Lila Thorn",
                13d,
                genreRepository.findByGenreType(GenreType.ADVENTURE),
                genreRepository.findByGenreType(GenreType.MYSTERY)
        ));
        bookRepository.save(new Book(
                5L,
                "The Time Traveler's Journal: Journeys Across Eras",
                "Cassandra Nightingale",
                10d,
                genreRepository.findByGenreType(GenreType.HISTORICAL)
        ));
        bookRepository.save(new Book(
                6L,
                "The Wizard and the Robot: Myths and Technology",
                "Maxwell Steele",
                15d,
                genreRepository.findByGenreType(GenreType.ADVENTURE)
        ));
        bookRepository.save(new Book(
                7L,
                "Calls from Distant Galaxies: Secrets of the Universe",
                "Luna Silvermoon",
                12d,
                genreRepository.findByGenreType(GenreType.SCI_FI),
                genreRepository.findByGenreType(GenreType.ADVENTURE)
        ));

        bookRepository.save(new Book(
                8L,
                "The Witch of the Wild",
                "Felix Stone",
                11d,
                genreRepository.findByGenreType(GenreType.FANTASY)
        ));

        bookRepository.save(new Book(
                9L,
                "In Pursuit of Reincarnation: Journeys of the Soul",
                "Isabella Waters",
                13d,
                genreRepository.findByGenreType(GenreType.ADVENTURE),
                genreRepository.findByGenreType(GenreType.FANTASY)
        ));

        bookRepository.save(new Book(
                10L,
                "The Encyclopedia of Fantasy Realms",
                "Adrian Darkwood",
                14d,
                genreRepository.findByGenreType(GenreType.FANTASY),
                genreRepository.findByGenreType(GenreType.ENCYCLOPEDIA)
        ));

        bookRepository.save(new Book(
                11L,
                "Surreal Realities: Waves of Modern Visual Arts",
                "Elena Starlight",
                12d,
                genreRepository.findByGenreType(GenreType.NON_FICTION),
                genreRepository.findByGenreType(GenreType.ADVENTURE)
        ));

        bookRepository.save(new Book(
                12L,
                "Coded Messages: Secrets of Cryptography",
                "Orion Skyfall",
                15d,
                genreRepository.findByGenreType(GenreType.NON_FICTION),
                genreRepository.findByGenreType(GenreType.HISTORICAL)
        ));

        bookRepository.save(new Book(
                13L,
                "The Earthly Eden: Preservation and Sustainability",
                "Serena Moonshade",
                11d,
                genreRepository.findByGenreType(GenreType.NON_FICTION)
        ));

        bookRepository.save(new Book(
                14L,
                "The Enchanted Past: Lost Civilizations and Cultures",
                "Marcus Nova",
                13d,
                genreRepository.findByGenreType(GenreType.HISTORICAL),
                genreRepository.findByGenreType(GenreType.ADVENTURE),
                genreRepository.findByGenreType(GenreType.MYSTERY)
        ));

        bookRepository.save(new Book(
                15L,
                "The Treasury of Memories: Memoirs and Recollections",
                "Clara Sunfire",
                12d,
                genreRepository.findByGenreType(GenreType.NON_FICTION)
        ));


        log.info("Finished initialization of Book.");
    }
    private void populateGenre() {
        log.info("Initialize Genres...");
        genreRepository.saveAll(getGenreList());
        log.info("Finished initialization of Genres.");
    }

    private List<Genre> getGenreList (){
        List<Genre> genreList = new ArrayList<>();
        for(GenreType genreType : GenreType.values()){
            genreList.add(new Genre(genreType));
        }
        return genreList;
    }


}
