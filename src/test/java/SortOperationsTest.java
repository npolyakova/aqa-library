import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;
import ru.library.Newspaper;

import java.time.Instant;
import java.util.*;

import static ru.library.GenerateUtils.generateSomeBooks;
import static ru.library.GenerateUtils.generateSomeNewsPapers;
import static ru.library.SortOperations.*;

public class SortOperationsTest {

    @Test
    public void shouldSortOperations() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(1, 2));
        Set<Category> categories = getBooksCategories(books);
        Assertions.assertNotNull(categories);
    }

    @Test
    public void shouldgetBooksByCategory() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(1, 2));
        Book book = new Book("bookName", "bookAuthor");
        Category category1 = new Category("Mybook");
        book.setCategory(category1);
        books.add(book);
        List<Book> booksByCategory = getBooksByCategory(books, category1);
        Assertions.assertEquals(booksByCategory.get(0).getCategory(), category1);
    }

    @Test
    public void shouldgetBooksNoCategory() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(1, 2));
        Category category1 = new Category("Mybook");
        List<Book> booksByCategory = getBooksByCategory(books, category1);
        Assertions.assertNull(booksByCategory);
    }

    @Test
    public void shouldsortNewspapersByDate() {
        Random r = new Random();
        List<Newspaper> newspapers = generateSomeNewsPapers(r.nextInt(3, 6));
        newspapers = sortNewspapersByDate(newspapers);
        Assertions.assertNotNull(newspapers);
    }

    @Test
    public void shouldCheckIfNewspaperHasCategory() {
        Random r = new Random();
        Newspaper newspaper = new Newspaper("News", Instant.now());
        List<Book> books = generateSomeBooks(r.nextInt(1, 2));
        books.add(newspaper);
        Assertions.assertEquals(getBooksCategories(books).size(), 0);
    }

}

