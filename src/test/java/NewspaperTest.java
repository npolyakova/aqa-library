import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Newspaper;

import java.util.concurrent.TimeUnit;


public class NewspaperTest {
    private static Faker faker = new Faker();
    @Test
    public void shouldSetNewspaper() {
        final Newspaper newspaper = new Newspaper("bookName", faker.date().past(20, TimeUnit.DAYS).toInstant());
        Assertions.assertNotNull(newspaper.getName());
        Assertions.assertNotNull(newspaper.getDate());
    }
}
