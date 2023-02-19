import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.GenerateUtils;
import ru.library.SearchOperations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static ru.library.GenerateUtils.generateSomeBooks;
import static ru.library.SearchOperations.getBookByName;
import static ru.library.SearchOperations.getBookByNameAndAuthor;

public class SearchOperationsTest {

    @Test
    public void shouldSearchOperations() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(0, 1));
        Book book = new Book("Two capitan", "Averin");
        books.add(book);
        Assertions.assertNotNull(getBookByNameAndAuthor("Two capitan", "Averin", books), "must be Averin");
        Assertions.assertNotNull(getBookByNameAndAuthor("Two capitan", "Averin", books), "must be Two capitanv");
    }
    public void shouldSearchOperationsNameBooks() {
        Random r = new Random();
        List<Book> books = generateSomeBooks(r.nextInt(0, 1));
        Book book = new Book("Two capitan", "Averin");
        books.add(book);
        Assertions.assertNotNull(getBookByName("Two capitan", books));
    }
}

