import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;
import ru.library.Newspaper;


import java.util.List;
import java.util.Optional;
import java.util.Random;

import static ru.library.GenerateUtils.generateSomeBooks;
import static ru.library.GenerateUtils.generateSomeNewsPapers;
import static ru.library.SearchOperations.getBookByName;
import static ru.library.SortOperations.getBooksByCategory;
import static ru.library.SearchOperations.getBookByNameAndAuthor;
import static ru.library.SortOperations.sortNewspapersByDate;

public class BookTest {

    @Test
    public void shouldSetCategory() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category("categoryName"));

        Assertions.assertNotNull(book.getCategory());
    }

    @Test
    public void shouldNotSetCategory() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category( null));
    }

    @Test
    public void shouldGenerateSomeBooks() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(30, 40));
    }

    @Test
    public void shouldGetBooksByCategory() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(39, 60));
        Book book = new Book("Война и мир", "Л.Н. Толстой");
        Category category1 = new Category("Роман");
        book.setCategory(category1);
        books.get(0).setCategory(category1);
        //books.add(book);

        List<Book> booksByCategory = getBooksByCategory(books, category1);
    }

    @Test
    public void shouldNotGetBooksByCategory() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(39, 60));
        Book book = new Book("Война и мир", "Л.Н. Толстой");
        Category category1 = new Category("");
        book.setCategory(category1);

        List<Book> booksByCategory = getBooksByCategory(books, category1);
    }

    @Test
    public void shouldGetBooksByName() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(3, 6));

        Optional<Book> foundBook = getBookByName("Война и мир", books);
    }

    @Test
    public void shouldGetBookByNameAndAuthor() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(4, 9));

        Optional<Book> foundBook = getBookByNameAndAuthor("Война и мир","Л.Н. Толстой", books);
    }

}
