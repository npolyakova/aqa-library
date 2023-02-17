package ru.library;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SearchOperations {

    public static Optional<Book> getBookByNameAndAuthor(String name, String author, List<Book> books) {
        return books.stream().filter(
                book -> Objects.equals(book.getName(), name) && Objects.equals(book.getAuthor(), author)
        ).findFirst();
    }

    public static Optional<Book> getBookByName(String name, List<Book> books) {
        return books.stream().filter(
                book -> Objects.equals(book.getName(), name)
        ).findFirst();
    }
}
