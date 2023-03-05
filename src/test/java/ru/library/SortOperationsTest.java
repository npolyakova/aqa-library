package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

class SortOperationsTest {

    @Test
    public void shouldGetBooksCategories() {
        List<Book> books = new ArrayList<>();
        Book book = new Book("Два капитана", "В. Каверин");
        Category category1 = new Category("Приключения");
        book.setCategory(category1);
        books.add(book);

        Assertions.assertTrue(SortOperations.getBooksCategories(books).contains(new Category("Приключения")));
    }
    @Test
    public void shouldBooksByCategoryPositive() {
        List<Book> books = new ArrayList<>();
        Book book = new Book("Два капитана", "В. Каверин");
        Category category1 = new Category("Приключения");
        book.setCategory(category1);
        books.add(book);

        Assertions.assertEquals("Приключения", SortOperations.getBooksByCategory(books,
                category1).get(0).getCategory().getName());
    }

    @Test
    public void shouldBooksByCategoryNegative() {
        List<Book> books = new ArrayList<>();
        Book book = new Book("Два капитана", "В. Каверин");
        Category category2 = new Category("Детектив");
        books.add(book);

        Assertions.assertNull(SortOperations.getBooksByCategory(books, category2));
    }
    @Test
    public void shouldBooksByCategoryNull() {
        List<Book> books = new ArrayList<>();
        Book book = new Book("Два капитана", "В. Каверин");
        Category category3 = new Category();
        books.add(book);

        Assertions.assertNull(SortOperations.getBooksByCategory(books, category3));
    }

    @Test
    public void sortNewspapersByDate() {
        List<Newspaper> newsPapers = new ArrayList<>();
        Newspaper newspaper1 = new Newspaper("Kazan", Instant.parse("2021-02-03T10:37:30.00Z"));
        newsPapers.add(newspaper1);
        Newspaper newspaper2 = new Newspaper("Vest", Instant.parse("2022-02-03T10:37:30.00Z"));
        newsPapers.add(newspaper2);

        Assertions.assertEquals("Vest", SortOperations.sortNewspapersByDate(newsPapers).get(0).getName());
        Assertions.assertEquals("Kazan", SortOperations.sortNewspapersByDate(newsPapers).get(1).getName());
    }



}