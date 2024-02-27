import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Newspaper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.library.GenerateUtils.generateSomeBooks;
import static ru.library.GenerateUtils.generateSomeNewsPapers;

public class GenerateUtilsTests extends TestBase{
    @Test
    void shouldGenerateSomeBooks() {
        List<Book> list = generateSomeBooks(5);

        assertEquals(5, list.size());
    }

    @Test
    void shouldGenerateSomeNewspapers() {
        List<Newspaper> list = generateSomeNewsPapers(3);

        assertEquals(3, list.size());
    }
}
