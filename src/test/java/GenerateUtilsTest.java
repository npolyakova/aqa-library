import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.GenerateUtils;
import ru.library.Newspaper;
import java.util.List;
public class GenerateUtilsTest {
    static GenerateUtils utils;
    @BeforeEach
    public void before(){
        utils = new GenerateUtils();
    }

    @Test
    public void shouldGenerateSomeBooks() {
        List<Book> res = utils.generateSomeBooks(4);

        Assertions.assertEquals(4, res.size());

    }
    @Test
    public void shouldGenerateSomeNewsPapers() {
        List<Newspaper> res = utils.generateSomeNewsPapers(4);

        Assertions.assertEquals(4, res.size());

    }
}
