package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SearchOperationsTest {

    @Test
    public void shouldGetBookByNameAndAuthor() {
        List<Book> books = new ArrayList<>();
        Book book = new Book("Два капитана", "В. Каверин");
        books.add(book);

        Assertions.assertEquals("Два капитана", SearchOperations.getBookByNameAndAuthor("Два капитана",
                "В. Каверин", books).get().getName());
        Assertions.assertEquals("В. Каверин", SearchOperations.getBookByNameAndAuthor("Два капитана",
                "В. Каверин", books).get().getAuthor());
    }

    @Test
    public void shouldGetBookByName() {
        List<Book> books = new ArrayList<>();
        Book book = new Book("Мастер и Маргарита", "М. Булгаков");
        books.add(book);

        Assertions.assertEquals("Мастер и Маргарита", SearchOperations.getBookByName("Мастер и Маргарита",
                books).get().getName());
    }


}