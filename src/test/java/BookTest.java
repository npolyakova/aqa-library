
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BookTest {
    private Book book;
    private ByteArrayOutputStream outContent;
    @BeforeEach
    public void setUp() {
        book = new Book("Name book", "Name Author");
        outContent = new ByteArrayOutputStream();
    }

    @Test
    @DisplayName("Проверяем назначение категории книге")
    public void shouldSetCategory() {
        book.setCategory(new Category("Category name"));

        Assertions.assertNotNull(book.getCategory());
    }

    @Test
    @DisplayName("Проверяем установку пустого значения NULL категории книг")
    public void shouldSetCategoryNull() {
        book.setCategory(new Category(null));

        Assertions.assertNull(book.getCategory());
    }

    @Test
    @DisplayName("Проверяем что пустое значение NULL категории выводит сообщение")
    public void shouldSetCategoryNullNotification() {
        System.setOut(new PrintStream(outContent));
        book.setCategory(new Category(null));

        Assertions.assertNull(book.getCategory());
        Assertions.assertEquals("Не получилось привязать категорию, категория не содержит имени\n"
                , outContent.toString());
    }
}
