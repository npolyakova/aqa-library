import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;

public class BookTest {

    @Test
    public void shouldSetCategory() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category("categoryName"));
        Assertions.assertNotNull(book.getName());
        Assertions.assertNotNull(book.getAuthor());
        Assertions.assertNotNull(book.getCategory());
    }
    @Test
    public void shouldnotSetCategory() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category(null));
        Assertions.assertNull(book.getCategory(), "Не получилось привязать категорию, категория не содержит имени");
    }

}
