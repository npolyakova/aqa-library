package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;


class GenerateUtilsTest {


    @Test
    public void shouldGenerateSomeNewsPapers() {
        Random r = new Random();
        int count = r.nextInt(3);
        List<Newspaper> newspapers =  GenerateUtils.generateSomeNewsPapers(count);
        Assertions.assertEquals(count, newspapers.size());
    }

    @Test
    public void shouldGenerateSomeBooks() {
        Random r = new Random();
        int count = r.nextInt(3);
        List<Book> books =  GenerateUtils.generateSomeBooks(count);
        Assertions.assertEquals(count, books.size());
    }


}