import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Newspaper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ru.library.GenerateUtils.generateSomeBooks;
import static ru.library.GenerateUtils.generateSomeNewsPapers;

public class GenerateUtilsTest {
    @Test
    public void shouldGenerateSomeBooks(){
        Random r = new Random();
        int count = r.nextInt(0,100);
        List<Book> books = new ArrayList<>();
        books = generateSomeBooks(count);
        Assertions.assertNotNull(books);
    }
    @Test
    public void shouldGenerateSomeNewsPapers(){
        Random r = new Random();
        int count = r.nextInt(0,100);
        List<Newspaper> newsPapers = new ArrayList<>();
        newsPapers = generateSomeNewsPapers(count);
        Assertions.assertNotNull(newsPapers);
    }
}
