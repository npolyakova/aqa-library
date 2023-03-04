package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static ru.library.SortOperations.*;

class SortOperationsTest {

    @Test
    void shouldGetBooksByCategoryPositive() {

        final List<Book> books = GenerateUtils.generateSomeBooks(3);
        Category category1 = new Category("category1");
        books.get(0).setCategory(category1);
        books.get(1).setCategory(category1);

        Assertions.assertEquals(getBooksByCategory(books, category1).size(), 2);
    }

    @Test
    void shouldGetBooksByCategoryNegative() {

        final List<Book> books = GenerateUtils.generateSomeBooks(3);
        Category category2 = new Category("category2");

        Assertions.assertNull(getBooksByCategory(books, category2));
    }
    //Cannot do it. I don't understand how can a newspaper be entered in getBooksCategories?
    @Test
    void shouldGetBooksByCategoryForNewspapers() {

    }

    @Test
    void ShouldSortNewspapersByDate () {
        List<Newspaper> newsPapers = new ArrayList<>();
        newsPapers.add( 0, new Newspaper("Name1", Instant.MAX));
        newsPapers.add(1, new Newspaper("Name2", Instant.MIN));
        newsPapers.add(2, new Newspaper("Name3", Instant.now()));
        List<Newspaper> newsPapersRes = sortNewspapersByDate(newsPapers);

        Assertions.assertEquals("Name3", newsPapersRes.get(1).getName());
    }
//    @Test
//    void ShouldCheckIfBookHasCategory () {
//        List<Newspaper> newsPapers = new ArrayList<>();
//        SearchOperations.
//
//        Assertions.assertEquals("Name3", newsPapersRes.get(1).getName());
//    }

}
