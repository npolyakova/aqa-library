package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.library.GenerateUtils.generateSomeBooks;
import static ru.library.SearchOperations.getBookByNameAndAuthor;

class SearchOperationsTest {

    @Test
    void ShouldGetBookByNameAndAuthor() {
        final List<Book> books = generateSomeBooks(3);
        books.add(new Book("NameBook", "NameAuthor"));
        String res = SearchOperations.getBookByNameAndAuthor ("NameBook","NameAuthor", books).get().getName();

        Assertions.assertEquals("NameBook", res);
    }

    @Test
    void ShouldGetBookByName() {
        final List<Book> books = generateSomeBooks(3);
        books.add(new Book("NameNewBook", "NameNewAuthor"));
        String res = SearchOperations.getBookByName ("NameNewBook", books).get().getName();

        Assertions.assertEquals("NameNewBook", res);
    }
}