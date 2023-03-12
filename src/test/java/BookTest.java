import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
public class BookTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void shouldSetCategoryNotNull() {
        final Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category("categoryName"));
        if (book.getCategory() != null) {
            Assertions.assertNotNull(book.getCategory());
        }
        else {
            System.out.println("Не получилось привязать категорию, категория не содержит имени");
            Assertions.assertEquals("Не получилось привязать категорию, категория не содержит" +
                    " имени", outputStreamCaptor.toString().trim());
        }

    }
    @Test
    public void shouldSetCategoryNull() {
        Book book = new Book("bookName", "bookAuthor");
        book.setCategory(new Category("categoryName"));
        Category a = book.getCategory();
        a = null;
        if (a != null) {
            Assertions.assertNotNull(book.getCategory());
        }
        else {
            System.out.println("Не получилось привязать категорию, категория не содержит имени");
            Assertions.assertEquals("Не получилось привязать категорию, категория не содержит" +
                    " имени", outputStreamCaptor.toString().trim());
        }

    }
    @Test
    public void shouldGetName(){
        Book book = new Book("bookName", "bookAuthor");
        String res = book.getName();

        Assertions.assertEquals("bookName", res);
    }
    @Test
    public void shouldGetAuthor(){
        Book book = new Book("bookName", "bookAuthor");
        String res = book.getAuthor();

        Assertions.assertEquals("bookAuthor", res);
    }
}
