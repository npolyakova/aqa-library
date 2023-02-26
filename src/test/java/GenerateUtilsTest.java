import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GenerateUtilsTest {

    @Test
    public void shouldGenerateSomeBooks(){
        List<Book> list = GenerateUtils.generateSomeBooks(3);

        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(3 ,list.size());
    }

    @Test
    public void shouldGenerateSomeBooks1(){
        List<Book> list = GenerateUtils.generateSomeBooks(0);

        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    public void shouldGenerateSomeNewsPapers(){
        List<Newspaper> list = GenerateUtils.generateSomeNewsPapers(3);

        Assertions.assertFalse(list.isEmpty());
        Assertions.assertEquals(3 ,list.size());
    }

    @Test
    public void shouldGenerateSomeNewsPapers2(){
        List<Newspaper> list = GenerateUtils.generateSomeNewsPapers(0);

        Assertions.assertTrue(list.isEmpty());

    }

}
