import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static ru.library.SearchOperations.getBookByName;
import static ru.library.SearchOperations.getBookByNameAndAuthor;

public class SearchOperationsTest {
    Faker faker = new Faker();

    @Test
    public void shouldGetBookByName() {
        String name = String.valueOf(faker.name());
        final List<Book> books = new ArrayList<>();
        books.add(new Book(faker.book().title(), faker.book().author()));
        Optional<Book> book = getBookByName(name, books);
        Assertions.assertNotNull(book);
    }

    @Test
    public void shouldGetBookByNameAndAuthor() {
        String name = String.valueOf(faker.name());
        String author = String.valueOf(faker.name());
        final List<Book> books = new ArrayList<>();
        books.add(new Book(faker.book().title(), faker.book().author()));
        Optional<Book> book = getBookByNameAndAuthor(name, author, books);
        Assertions.assertNotNull(book);
    }
}
