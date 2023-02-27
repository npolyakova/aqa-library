import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import ru.library.Book;
import ru.library.SearchOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchOperationsTest {
  private Book book;
  private List<Book> booksArray;
  private static Faker faker = new Faker();

  @BeforeEach
  public void setUp(){
    book = new Book(faker.book().title(), faker.book().author());
    booksArray = new ArrayList<>();
    booksArray.add(book);
  }

  @Test
  @DisplayName("Проверка поиска по Названию книги и Автору")
  void shouldGetBookByNameAndAuthor() {
    Optional<Book> list = SearchOperations.
            getBookByNameAndAuthor(book.getName(), book.getAuthor(), booksArray);

    Assertions.assertEquals(book.getName(),list.get().getName());
    Assertions.assertEquals(book.getAuthor(),list.get().getAuthor());
  };

  @Test
  @DisplayName("Проверка поиска по Названию книги")
  void shouldGetBookByName() {
    Optional<Book> list = SearchOperations.
            getBookByName(book.getName(), booksArray);

    Assertions.assertEquals(book.getName()
            , list.get().getName());
  };
}
