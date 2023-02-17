package ru.library;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GenerateUtils {

    private static Faker faker = new Faker();

    public static List<Book> generateSomeBooks(int count) {
        final List<Book> books = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            books.add(new Book(faker.book().title(), faker.book().author()));
        }
        return books;
    }

    public static List<Newspaper> generateSomeNewsPapers(int count) {
        final List<Newspaper> newsPapers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            newsPapers.add(new Newspaper(faker.book().title(), faker.date().past(20, TimeUnit.DAYS).toInstant()));
        }
        return newsPapers;
    }
}

