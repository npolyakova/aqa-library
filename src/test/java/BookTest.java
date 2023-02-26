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
    public void shouldSetCategory2() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Book book = new Book("bookName1", "bookAuthor1");
        book.setCategory(new Category(null));
        Assertions.assertEquals(
                "Не получилось привязать категорию, категория не содержит имени" + "\r\n",
                outContent.toString()
        );
    }
    @Test
    public void shouldGetName(){
        String bookName="Мурзилка";
        String authorName = "Пушкин";
        Book book = new Book(bookName, authorName);
        Assertions.assertEquals(bookName, book.getName());
    }
    @Test
    public void shouldGetAuthor(){
        String bookName="Мурзилка";
        String authorName = "Пушкин";
        Book book = new Book(bookName, authorName);
        Assertions.assertEquals(authorName, book.getAuthor());
    }
}
