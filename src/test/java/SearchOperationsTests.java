import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.library.GenerateUtils.generateSomeBooks;
import static ru.library.SearchOperations.getBookByName;
import static ru.library.SearchOperations.getBookByNameAndAuthor;

public class SearchOperationsTests extends TestBase {


    @Test
    void shouldGetBookByNameAndAuthor() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(3, 6));
        Book book = new Book("Трое в лодке", "К. Торонтино");
        Category category1 = new Category("Трое в лодке");
        book.setCategory(category1);
        books.get(0).setCategory(category1);
        books.add(book);
        Optional<Book> foundBook = getBookByNameAndAuthor("Трое в лодке", "К. Торонтино", books);

        assertEquals("Трое в лодке", foundBook.get().getName());
        assertEquals("К. Торонтино", foundBook.get().getAuthor());
    }

    @Test
    void shouldGetBookByName() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(3, 6));
        Book book = new Book("Трое в лодке", "В. Каверин");
        Category category1 = new Category("Ужасы");
        book.setCategory(category1);
        books.get(0).setCategory(category1);
        books.add(book);
        Optional<Book> foundBook = getBookByName("Трое в лодке", books);

        assertEquals("Трое в лодке", foundBook.get().getName());
    }

}
