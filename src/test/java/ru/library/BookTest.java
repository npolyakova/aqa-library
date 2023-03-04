package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class BookTest {


    @ParameterizedTest
    @MethodSource("bookAuthors")
    public void shouldSetCategoryPositive(String bookName, String author, String categoryName) {
        final Book book = new Book (bookName, author);
        book.setCategory(new Category(categoryName));

        Assertions.assertNotNull(book.getCategory());
    }

    private static Stream<Arguments> bookAuthors() {
        return Stream.of(
                Arguments.of("bookName1", "bookAuthor1", "category1"),
                Arguments.of("bookName2", "bookAuthor2", "category2")
        );
    }

    @Test
    public void shouldSetCategoryNegative(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category(null));

        Assertions.assertEquals("some text", outContent.toString());
    }

    @Test
    public void shouldGetName () {
        final Book book = new Book ("bookName3", "bookAuthor3");
        String res = book.getName();

        Assertions.assertEquals("bookName3", res);
    }

    @Test
    public void shouldGetAuthor () {
        final Book book = new Book ("bookName4", "bookAuthor4");
        String res = book.getAuthor();

        Assertions.assertEquals("bookAuthor4", res);
    }
}
