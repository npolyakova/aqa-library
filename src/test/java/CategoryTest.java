import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Category;

public class CategoryTest {
    Faker faker = new Faker();
    @Test
    public void shouldGetName() {
        String name = String.valueOf(faker.name());
        Category category = new Category(name);
        Assertions.assertEquals(name, category.getName());
    }
}
