import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;
import ru.library.SearchOperations;
import ru.library.SortOperations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class SearchOperationTest {

    @Test
    public void shouldGetBookByNameAndAuthor() {
        Book book = new Book("name", "1");
        List<Book> objectForBook = new ArrayList<>();
        objectForBook.add(book);
        Optional<Book> list =  SearchOperations.getBookByNameAndAuthor("name", "1", objectForBook);

        Assertions.assertEquals(book.getName(), list.get().getName());
        Assertions.assertEquals(book.getAuthor(), list.get().getAuthor());

    }
    @Test
    public void shouldGetBookByNameAndAuthor2() {
        Book book = new Book("name1", "1");
        List<Book> objectForBook = new ArrayList<>();
        objectForBook.add(book);
        Optional<Book> list =  SearchOperations.getBookByNameAndAuthor("name", "1", objectForBook);

        Assertions.assertTrue(list.isEmpty());

    }

    @Test
    public void shouldGetBookByNameAndAuthor3() {
        Book book = new Book("name", "10");
        List<Book> objectForBook = new ArrayList<>();
        objectForBook.add(book);
        Optional<Book> list =  SearchOperations.getBookByNameAndAuthor("name", "1", objectForBook);

        Assertions.assertTrue(list.isEmpty());

    }

    @Test
    public void shouldGetBookByNameAndAuthor4() {
        Book book = new Book("name", "10");
        List<Book> objectForBook = new ArrayList<>();
        objectForBook.add(book);
        Optional<Book> list =  SearchOperations.getBookByNameAndAuthor("name", "1", objectForBook);

        Assertions.assertTrue(list.isEmpty());

    }

    @Test
    public void shouldGetBookByName() {
        Book book = new Book("name", "10");
        List<Book> objectForBook = new ArrayList<>();
        objectForBook.add(book);
        Optional<Book> list =  SearchOperations.getBookByName("name", objectForBook);

        Assertions.assertEquals(book.getName(), list.get().getName());

    }

    @Test
    public void shouldGetBookByName2() {
        Book book = new Book("name1", "10");
        List<Book> objectForBook = new ArrayList<>();
        objectForBook.add(book);
        Optional<Book> list =  SearchOperations.getBookByName("name", objectForBook);

        Assertions.assertTrue(list.isEmpty());

    }

    @Test
    public void shouldGetBookByName3() {
        List<Book> objectForBook = new ArrayList<>();
        Optional<Book> list =  SearchOperations.getBookByName("name", objectForBook);

        Assertions.assertTrue(list.isEmpty());
    }

}

