import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.GenerateUtils;

public class GenerateUtilsTest {

    @Test
    public void shouldGenerateSomeBooks() {
        Assertions.assertNotNull(GenerateUtils.generateSomeBooks(3));
    }

    @Test
    public void shouldGenerateNewsPapers() {
        Assertions.assertNotNull(GenerateUtils.generateSomeNewsPapers(3));
    }
}
