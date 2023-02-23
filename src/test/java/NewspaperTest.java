import org.junit.jupiter.api.Test;
import ru.library.Newspaper;

import java.util.List;
import java.util.Random;


import static ru.library.GenerateUtils.generateSomeNewsPapers;
import static ru.library.SortOperations.sortNewspapersByDate;

public class NewspaperTest {
    @Test
    public void shouldGenerateSomeNewspaper() {
        Random r = new Random();
        List<Newspaper> newspapers = generateSomeNewsPapers(r.nextInt(6, 12));
        newspapers = sortNewspapersByDate(newspapers);
    }

    @Test
    public void shouldSortNewspaper() {
        Random r = new Random();
        List<Newspaper> newspapers = generateSomeNewsPapers(r.nextInt(6, 12));
        newspapers = sortNewspapersByDate(newspapers);
    }

}
