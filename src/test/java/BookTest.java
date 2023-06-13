import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;

public class BookTest {

    @Test
    public void shouldSetCategory() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category("categoryName"));

        Assertions.assertNotNull(book.getCategory());
    }
}

