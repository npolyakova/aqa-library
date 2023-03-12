import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.SortOperations;
import java.util.ArrayList;
import java.util.List;
import static ru.library.SortOperations.checkIfBookHasCategory;

//Не хватило времени рабораться в коде SortOperations, чтобы написать тесты.
//Для методы в SortOperations оказались сложноватыми
public class SortOperationsTest {
    @Test
    public void shouldCheckIfBookHasCategorys() {
        Book book = new Book("Dot com", "Савин");

        SortOperations sortOperations = new SortOperations();
        checkIfBookHasCategory(book);

        Assertions.assertFalse(checkIfBookHasCategory(book));

    }
    @Test
    public void shouldGetBooksCategories() {
        Book book = new Book("Dot com", "Савин");
        List<Book> books = new ArrayList<>();
        books.add(book);

        SortOperations sortOperations = new SortOperations();
        sortOperations.getBooksCategories(books);

        Assertions.assertNotNull(sortOperations.getBooksCategories(books));

    }
}
