package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void shouldSetCategory() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category());

        Assertions.assertNull(book.getCategory());
    }

}
