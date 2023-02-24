import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void shouldSetCategory() {
        Book book = new Book("Замок", "Франц Кафка");
        Category category = new Category("Художественная литература");
        book.setCategory(category);

        Assertions.assertEquals(category, book.getCategory());
    }

    @Test
    public void shouldSetCategoryWithoutCategory() {
        Book book = new Book("Бойцовский клуб", "Чак Паланик");
        Category category = new Category(null);
        book.setCategory(category);

        assertThat(out.toString()).startsWith("Не получилось привязать категорию, категория не содержит имени");
    }
}
