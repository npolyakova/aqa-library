package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static ru.library.GenerateUtils.generateSomeBooks;

class SortOperationsTest {

    @Test
    public void shouldGetBooksCategories() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(3));
        Book book = new Book("Два капитана", "В. Каверин");
        Category category1 = new Category("Приключения");
        book.setCategory(category1);
        books.get(0).setCategory(category1);
        books.add(book);

        Assertions.assertTrue(SortOperations.getBooksCategories(books).contains(new Category("Приключения")));
    }

    @Test
    public void shouldBooksByCategory() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(3));
        Book book = new Book("Два капитана", "В. Каверин");
        Category category1 = new Category("Приключения");
        book.setCategory(category1);
        books.get(0).setCategory(category1);
        books.add(book);

        Assertions.assertTrue(SortOperations.getBooksByCategory(books).contains(new Category("Приключения")));
    }


}