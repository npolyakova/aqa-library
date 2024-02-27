import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;
import ru.library.Newspaper;

import java.time.Instant;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static ru.library.GenerateUtils.generateSomeBooks;
import static ru.library.GenerateUtils.generateSomeNewsPapers;
import static ru.library.SortOperations.*;

public class SortOperationsTests extends TestBase{
    @Test
    void shouldSortNewspapersByDate() {
        Random r = new Random();
        List<Newspaper> newspapers = generateSomeNewsPapers(r.nextInt(3, 6));
        sortNewspapersByDate(newspapers);

        assertNotNull(newspapers.get(0).getDate());
    }

    @Test
    void shouldCheckIfBookHasCategory() {
        Instant now = Instant.now();
        final Newspaper newspaper = new Newspaper("NewspaperName", now);
        checkIfBookHasCategory(newspaper);

        assertTrue(outContent.toString().startsWith("Газеты не сортируются"));

    }

    @Test
    void shouldGetBooksCategories() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(3, 6));
        Book book = new Book("Трое в лодке", "К. Торонтино");
        Category category = new Category("Драма");
        book.setCategory(category);
        books.get(0).setCategory(category);
        books.add(book);
        List<Book> booksByCategory = getBooksByCategory(books, category);

        assertEquals("Драма", booksByCategory.get(0).getCategory().getName());
    }

    @Test
    void shouldGetBooksCategoriesNegativeTest() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(3, 6));
        Book book = new Book("Один дома", "Б. Омж");
        Category category = new Category("Ужасы");
        books.add(book);
        getBooksByCategory(books, category);

        assertTrue(outContent.toString().startsWith("В библиотеке нет книг"));
    }

}
