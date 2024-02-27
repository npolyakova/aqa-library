import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.library.Newspaper;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NewspaperTests extends TestBase{
    @Test
    void shouldSetDateNewspaper() {
        Instant now = Instant.now();
        final Newspaper newspaper = new Newspaper("NewspaperName", now);

        assertNotNull(newspaper.getDate());
    }

    @Test
    void shouldSetNameNewspaper() {
        Instant now = Instant.now();
        final Newspaper newspaper = new Newspaper("NewspaperName", now);

        assertNotNull(newspaper.getName());
    }

}
