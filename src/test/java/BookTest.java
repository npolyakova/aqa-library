import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.*;

import java.time.Instant;
import java.util.*;

import static ru.library.GenerateUtils.generateSomeBooks;
import static ru.library.GenerateUtils.generateSomeNewsPapers;

public class BookTest {

    @Test
    public void shouldSetCategory() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category("categoryName"));

        Assertions.assertNotNull(book.getCategory());
        Assertions.assertNotNull(book.getName());
        Assertions.assertNotNull(book.getAuthor());
    }

    @Test
    public void shouldGenerateSomeBooks() {
        List<Book> bookList = GenerateUtils.generateSomeBooks(5);
        int lengthOfBookList = bookList.size();
        Assertions.assertEquals(5, lengthOfBookList);
    }

    @Test
    public void shouldGenerateSomeNewsPapers() {
        List<Newspaper> newsPapersList = GenerateUtils.generateSomeNewsPapers(5);
        int lengthOfBookList = newsPapersList.size();
        Assertions.assertEquals(5, lengthOfBookList);
    }

    @Test
    public void shouldGetNameOfNewsPaper() {
        List<Newspaper> newsPapersList = GenerateUtils.generateSomeNewsPapers(1);
        Newspaper newspaper = newsPapersList.get(0);
        Instant date = newspaper.getDate();
        Assertions.assertNotNull(date);
    }

    @Test
    public void shouldGetBookByNameAndAuthor() {
        List<Book> books = generateSomeBooks(3);

        Book book = new Book("Два капитана", "В. Каверин");
        Category category1 = new Category("Приключения");
        book.setCategory(category1);
        books.get(0).setCategory(category1);
        books.add(book);

        Optional<Book> booksByCategory = SearchOperations.getBookByNameAndAuthor("Два капитана", "В. Каверин", books);
        Assertions.assertNotNull(booksByCategory);
    }

    @Test
    public void shouldGetBookByName() {
        List<Book> books = generateSomeBooks(3);

        Book book = new Book("Два капитана", "В. Каверин");
        Category category1 = new Category("Приключения");
        book.setCategory(category1);
        books.get(0).setCategory(category1);
        books.add(book);

        Optional<Book> booksByName = SearchOperations.getBookByName("Два капитана", books);
        Assertions.assertNotNull(booksByName);
    }

    @Test
    public void shouldGetBooksCategories() {
        List<Book> books = generateSomeBooks(3);

        Book book = new Book("Два капитана", "В. Каверин");
        Category category1 = new Category("Приключения");
        book.setCategory(category1);
        books.get(0).setCategory(category1);
        books.add(book);

        Set<Category> booksCategories = SortOperations.getBooksCategories(books);
        Assertions.assertNotNull(booksCategories);
        int countOfCategories = booksCategories.size();
        Assertions.assertEquals(2, countOfCategories);
    }

    @Test
    public void shouldntGetBookCategory() {
        Book book = new Book("Два капитана", "В. Каверин");
        Category category1 = new Category(null);
        book.setCategory(category1);
        Category category = book.getCategory();

        Assertions.assertNull(category);
    }

    @Test
    public void shouldntGetNewsPapersCategories() {
        List<Newspaper> newspapers = generateSomeNewsPapers(3);
        List<Book> listOfNewspaperAsBooks = new ArrayList<>();
        for (Newspaper newspaper : newspapers) listOfNewspaperAsBooks.add((Book) newspaper);

        Set<Category> newsPapersCategory = SortOperations.getBooksCategories(listOfNewspaperAsBooks);
        int countOfCategories = newsPapersCategory.size();
        Assertions.assertEquals(0, countOfCategories);
    }

    @Test
    public void shouldGetBooksByCategoryFirst() {
        List<Book> books = generateSomeBooks(3);

        Book book = new Book("Два капитана", "В. Каверин");
        Category category1 = new Category("Приключения");
        book.setCategory(category1);
        books.get(0).setCategory(category1);
        books.add(book);

        List<Book> booksByCategory = SortOperations.getBooksByCategory(books, category1);
        Assertions.assertNotNull(booksByCategory);
        int countOfCategories = booksByCategory.size();
        Assertions.assertEquals(2, countOfCategories);
    }

    @Test
    public void shouldGetBooksByCategorySecond() {
        List<Book> books = generateSomeBooks(3);

        Book book = new Book("Два капитана", "В. Каверин");
        Category category1 = new Category("Приключения");
        Category category2 = new Category("Фэнтази");
        book.setCategory(category1);
        books.get(0).setCategory(category1);
        books.add(book);


        List<Book> booksByCategory = SortOperations.getBooksByCategory(books, category2);
        Assertions.assertNull(booksByCategory);
    }

    @Test
    public void shouldSortNewsPapersByDate() {
        List<Newspaper> newspapers = generateSomeNewsPapers(3);

        List<Newspaper> sortedNewspapersByDate = SortOperations.sortNewspapersByDate(newspapers);
        Assertions.assertNotNull(sortedNewspapersByDate);
        int countOfCategories = sortedNewspapersByDate.size();
        Assertions.assertEquals(3, countOfCategories);
    }

}
