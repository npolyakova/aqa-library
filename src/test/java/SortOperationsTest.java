import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;
import ru.library.SortOperations;

import java.util.ArrayList;
import java.util.List;

public class SortOperationsTest {
  private Book book;
  private List<Book> booksArray;
  private static Faker faker = new Faker();

  @BeforeEach
  public void sutUp() {
    booksArray = new ArrayList<>();

    for(int i = 0; i < 3; i++){
      book = new Book(faker.book().title(), faker.book().author());
      booksArray.add(book);
    }
  }

  @Test
  @DisplayName("Проверка возрата массива категорий")
  void shouldGetBooksCategories() {
    for ( Book book : booksArray) {
      book.setCategory(new Category (faker.book().genre()));
    }

    Assertions.assertNotNull(SortOperations.getBooksCategories(booksArray));
  }
}
