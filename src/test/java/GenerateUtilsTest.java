
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.GenerateUtils;
import ru.library.Newspaper;
import java.util.List;

public class GenerateUtilsTest {
  private List<Book> books;
  private List<Newspaper> newsPapers;

  @Test
  @DisplayName("Проверка генерации списка книг")
  void shouldGenerateSomeBooks() {
    books = GenerateUtils.generateSomeBooks(5);

    Assertions.assertFalse(books.isEmpty());
    Assertions.assertEquals(5 ,books.size());
  }

  @Test
  @DisplayName("Проверка генерации списка газет")
  void shouldGenerateSomeNewsPapers() {
    newsPapers = GenerateUtils.generateSomeNewsPapers(5);

    Assertions.assertFalse(newsPapers.isEmpty());
    Assertions.assertEquals(5 ,newsPapers.size());
  }
}

