package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static ru.library.GenerateUtils.generateSomeBooks;

class SearchOperationsTest {

    @Test
    public void shouldGetBookByNameAndAuthor() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(3));
        Book book = new Book("Два капитана", "В. Каверин");
        books.add(book);

        Assertions.assertEquals("Два капитана", SearchOperations.getBookByNameAndAuthor("Два капитана", "В. Каверин", books).get().getName());
        Assertions.assertEquals("В. Каверин", SearchOperations.getBookByNameAndAuthor("Два капитана", "В. Каверин", books).get().getAuthor());
    }

    @Test
    public void shouldGetBookByName() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(3));
        Book book = new Book("Мастер и Маргарита", "М. Булгаков");
        books.add(book);

        Assertions.assertEquals("Мастер и Маргарита", SearchOperations.getBookByName("Мастер и Маргарита",  books).get().getName());
    }


}