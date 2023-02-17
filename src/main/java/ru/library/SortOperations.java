package ru.library;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortOperations {

    private static boolean checkIfBookHasCategory(Book book) {
        if (book.getClass() == Newspaper.class) {
            System.out.println("Газеты не сортируются по категориям");
            return false;
        } else {
            return book.getCategory() != null;
        }
    }

    public static Set<Category> getBooksCategories(List<Book> books) {
        final Set<Category> categories = new HashSet<>();
        books.forEach(book -> {
            if (checkIfBookHasCategory(book)) {
                categories.add(book.getCategory());
            }
        });
        return categories;
    }

    public static List<Book> getBooksByCategory(List<Book> books, Category category) {
        Set<Category> categories = getBooksCategories(books);
        List<Book> booksOfCategory = new ArrayList<>();
        if (categories.contains(category)) {
            books.forEach(book -> {
                        if (book.getCategory() == category) {
                            booksOfCategory.add(book);
                        }
                    }
            );
            return booksOfCategory;
        } else {
            System.out.println("В библиотеке нет книг с заданной категорией");
            return null;
        }
    }

    public static List<Newspaper> sortNewspapersByDate(List<Newspaper> newspapers) {
        newspapers.sort(Comparator.comparing(Newspaper::getDate).reversed());
        return newspapers;
    }
}
