import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Newspaper;

import java.time.Instant;

public class NewspaperTest {
    @Test
    public void shouldGetDate(){
        String name = "Pravda";
        Instant date = Instant.now();
        Newspaper newspaper = new Newspaper(name,date);
        Assertions.assertEquals(date,newspaper.getDate());
    }
}
