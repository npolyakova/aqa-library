package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

class GenerateUtilsTest {

    @Test
    public void shouldGenerateSomeBooks() {
        final List<Book> res = GenerateUtils.generateSomeBooks(3);

        Assertions.assertFalse(res.isEmpty());
    }


    @Test
    public void shouldGenerateSomeNewsPapers() {
        final List<Newspaper> res = GenerateUtils.generateSomeNewsPapers(3);

        Assertions.assertFalse(res.isEmpty());
    }
}

