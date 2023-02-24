import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.SearchOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchOperationsTest {

    @Test
    public void shouldGetBookByNameAndAuthor() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Идиот", "Достоевский"));
        Optional<Book> result = SearchOperations.getBookByNameAndAuthor("Идиот", "Достоевский", books);

        Assertions.assertEquals("Идиот", result.get().getName());
        Assertions.assertEquals("Достоевский", result.get().getAuthor());
    }

    @Test
    public void shouldGetBookByNameAndAuthorWrongName() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Бесы", "Достоевский"));
        Optional<Book> result = SearchOperations.getBookByNameAndAuthor("Бесы", "Достоевский", books);

        Assertions.assertNotEquals("Идиот", result.get().getName());
    }

    @Test
    public void shouldGetBookByNameAndAuthorWrongAuthor() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Идиот", "Булгаков"));
        Optional<Book> result = SearchOperations.getBookByNameAndAuthor("Идиот", "Булгаков", books);

        Assertions.assertNotEquals("Достоевский", result.get().getAuthor());
    }

    @Test
    public void shouldGetBookByNameAndAuthorEmpty() {
        List<Book> books = new ArrayList<>();
        Optional<Book> result = SearchOperations.getBookByNameAndAuthor("Идиот", "Достоевский", books);

        Assertions.assertNotNull(result);
    }

    @Test
    public void shouldGetBookByName() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1984", "Оруэлл"));
        Optional<Book> result = SearchOperations.getBookByName("1984", books);

        Assertions.assertEquals("1984", result.get().getName());

    }
}
