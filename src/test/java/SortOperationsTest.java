import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;
import ru.library.Newspaper;
import ru.library.SortOperations;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SortOperationsTest {

    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(out));
    }

    @Test
    public void shouldGetBooksCategories() {
        List<Book> books = new ArrayList<>();
        Category cat1 = new Category("Фантастика");
        Category cat2 = new Category("Военная литература");
        Category cat3 = new Category("Биографии");
        books.add(new Book("Голодные игры", "Сьюзен Коллинз"));
        books.get(0).setCategory(cat1);
        books.add(new Book("Весь невидимый нам свет", "Энтони Дорр"));
        books.get(1).setCategory(cat2);
        books.add(new Book("Любить кого-то", "Грейс Слик"));
        books.get(2).setCategory(cat3);
        Set<Category> result = SortOperations.getBooksCategories(books);

        Assertions.assertTrue(result.contains(cat1));
        Assertions.assertTrue(result.contains(cat2));
        Assertions.assertTrue(result.contains(cat3));
    }

    @Test
    public void shouldGetBooksCategoriesEmptyBooks() {
        List<Book> books = new ArrayList<>();
        Set<Category> result = SortOperations.getBooksCategories(books);

        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void shouldGetBooksCategoriesEmptyCategory() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(null, "Джек Лондон"));
        Set<Category> result = SortOperations.getBooksCategories(books);

        Assertions.assertEquals(0, result.size());
    }

    @Test
    public void shouldGetBooksByCategory() {
        Book book1 = new Book("Облачный атлас", "Дэвид Митчелл");
        Book book2 = new Book("Игра в бисер", "Герман Гессе");
        Book book3 = new Book("Триумфальная арка", "Эрих Мария Ремарк");
        Category cat1 = new Category("Антиутопии");
        Category cat2 = new Category("Художественная литература");
        book1.setCategory(cat1);
        book2.setCategory(cat2);
        book3.setCategory(cat2);
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        List<Book> booksCat1 = SortOperations.getBooksByCategory(books, cat1);
        List<Book> booksCat2 = SortOperations.getBooksByCategory(books, cat2);

        Assertions.assertEquals(1, booksCat1.size());
        Assertions.assertTrue(booksCat1.contains(book1));
        Assertions.assertEquals(2, booksCat2.size());
        Assertions.assertTrue(booksCat2.contains(book2));
    }

    @Test
    public void shouldGetBooksByCategoryEmptyBooks() {
        Category cat = new Category("Тестирование ПО");
        List<Book> books = new ArrayList<>();
        List<Book> booksCat = SortOperations.getBooksByCategory(books, cat);
        assertThat(out.toString()).startsWith("В библиотеке нет книг с заданной категорией");
    }

    @Test
    public void shouldSortNewspapersByDate() {
        Newspaper np1 = new Newspaper("Криминальные коты", Instant.parse("2021-01-01T00:00:00.00Z"));
        Newspaper np2 = new Newspaper("Ежедневный пророк", Instant.parse("2022-01-01T00:00:00.00Z"));
        Newspaper np3 = new Newspaper("дВести сос мыслом", Instant.parse("2023-01-01T00:00:00.00Z"));
        List<Newspaper> nps = new ArrayList<>();
        nps.add(np1);
        nps.add(np2);
        nps.add(np3);
        List<Newspaper> sort = SortOperations.sortNewspapersByDate(nps);

        Assertions.assertEquals(np3, sort.get(0));
        Assertions.assertEquals(np2, sort.get(1));
        Assertions.assertEquals(np1, sort.get(2));
    }
}
