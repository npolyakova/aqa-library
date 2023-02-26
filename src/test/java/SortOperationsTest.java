import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static ru.library.SortOperations.getBooksByCategory;
import static ru.library.SortOperations.getBooksCategories;

public class SortOperationsTest {
    Faker faker = new Faker();
    @Test
    void shouldGetBooksCategories() {
        final List<Book> books = new ArrayList<>();
        books.add(new Book("pravda","pushkin"));
        books.get(0).setCategory(new Category("TestCategory"));
        Set<Category> categories= getBooksCategories(books);
        Assertions.assertEquals("TestCategory", categories.stream().findFirst().orElse(new Category("")).getName());
    }
    @Test
    void shouldGetBooksByCategory() {
        final List<Book> books = new ArrayList<>();
        books.add(new Book("Приключения", faker.book().author()));
        Set<Category> categories= getBooksCategories(books);
        Category category1 = new Category("Приключения");
        books.get(0).setCategory(category1);
        List<Book> booksByCategory= getBooksByCategory(books,category1);
        Assertions.assertEquals(books.get(0).getName(),booksByCategory.get(0).getName());
    }
}
