import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest extends TestBase{



    @Test
    void shouldSetBookName() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category(null));

        assertNotNull(book.getName());
    }

    @Test
    void shouldSetBookAuthor() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category(null));

        assertNotNull(book.getAuthor());
    }
    @Test
    void shouldSetEmptyCategory() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category(null));

        assertTrue(outContent.toString().startsWith("Категория не содержит имени"));
    }

}
