package ru.library;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static ru.library.GenerateUtils.generateSomeBooks;
import static ru.library.GenerateUtils.generateSomeNewsPapers;
import static ru.library.SearchOperations.getBookByName;
import static ru.library.SearchOperations.getBookByNameAndAuthor;
import static ru.library.SortOperations.getBooksByCategory;
import static ru.library.SortOperations.sortNewspapersByDate;

public class Main {

    //На этот класс тесты писать не надо. Он демонстрирует работу методов

    public static void main(String[] args) {

        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(3, 6));

        Book book = new Book("Два капитана", "В. Каверин");
        Category category1 = new Category("Приключения");
        book.setCategory(category1);
        books.get(0).setCategory(category1);
        books.add(book);

        List<Book> booksByCategory = getBooksByCategory(books, category1);
        booksByCategory.forEach(b -> System.out.println(b.getCategory().getName() + " " + b.getName()));

        List<Newspaper> newspapers = generateSomeNewsPapers(r.nextInt(3, 6));
        newspapers = sortNewspapersByDate(newspapers);

        newspapers.forEach(n -> System.out.println(n.getDate()));

        Optional<Book> foundBook = getBookByName("Два капитана", books);
        System.out.println(foundBook.get().getName());
        System.out.println(getBookByNameAndAuthor("Два капитана", "В. Каверин", books).get().getAuthor());
    }
}
