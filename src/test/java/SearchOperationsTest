import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.SearchOperations;
import java.util.ArrayList;
import java.util.List;
public class SearchOperationsTest {
    @Test
    public void shouldGetBookByNameAndAuthor() {
        Book book = new Book("Dot com", "Савин");
        List<Book> books = new ArrayList<>();
        books.add(book);

        SearchOperations searchOperations = new SearchOperations();
        String name = "Dot com";
        String author = "Савин";
        searchOperations.getBookByNameAndAuthor(name, author, books);

        Assertions.assertTrue(name == books.get(0).getName());
        Assertions.assertTrue(author == books.get(0).getAuthor());


    }
    @Test
    public void shouldGetBookByName() {
        Book book = new Book("Dot com","Савин");
        List<Book> books = new ArrayList<>();
        books.add(book);

        SearchOperations searchOperations = new SearchOperations();
        String name = "Dot com";

        searchOperations.getBookByName(name, books);
        Assertions.assertEquals(name, books.get(0).getName());
    }
}
