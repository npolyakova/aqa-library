import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BookTest {

    @Test
    public void shouldSetCategory() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category("categoryName"));

        Assertions.assertNotNull(book.getCategory());
    }

    @Test
    public void shouldSetCategoryNull(){
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category(null));

        Assertions.assertEquals("Не получилось привязать категорию, категория не содержит имени\r\n", outContent.toString());
    }
}
