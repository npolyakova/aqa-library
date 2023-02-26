import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.library.Book;
import ru.library.Category;
import ru.library.Newspaper;
import ru.library.SortOperations;
import java.time.Instant;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.DoubleToIntFunction;


public class SortOperationsTest {

    @Test
    public void shouldSetCategoryNull(){
        Book bookTest = new Newspaper("Name", Instant.now());
        List<Book> bookTestList = List.of(bookTest);
        Set<Category> booksCategories = SortOperations.getBooksCategories(bookTestList);

        Assertions.assertTrue(booksCategories.isEmpty());
    }

    @Test
    public void shouldGetBooksByCategory() {
        List<Book> listBook = new ArrayList<>();
        Category category = new Category("name");
        List<Book> booksOfCategory = SortOperations.getBooksByCategory(listBook, category);

        Assertions.assertNull(booksOfCategory);
    }

//    @Test
//    public void shouldSortOperations() {
//        List<Book> booksByCategory = SortOperations.getBooksByCategory(null, null);
//
//        Assertions.assertNotNull(booksByCategory);
//        Assertions.assertTrue(booksByCategory.isEmpty());
//    }

//    @Test
//    public void shouldSortOperations2() {
//        List<Book> objects = new ArrayList<>();
//        List<Book> booksByCategory = SortOperations.getBooksByCategory(objects, null);
//
//        Assertions.assertNotNull(booksByCategory);
//        Assertions.assertTrue(booksByCategory.isEmpty());
//    }

//    @Test
//    public void shouldSortOperations3() {
//        Category category = new Category("name");
//        List<Book> booksByCategory = SortOperations.getBooksByCategory(null, category);
//
//        Assertions.assertNotNull(booksByCategory);
//        Assertions.assertTrue(booksByCategory.isEmpty());
//    }

    @Test
    public void shouldSortOperations4() {
        Category category = new Category("name");
        Book book1 = new Book("name1", "1");
        Book book2 = new Book("name2", "2");
        book1.setCategory(category);
        List<Book> object = new ArrayList<>();
        object.add(book1);
        object.add(book2);
        List<Book> booksByCategory = SortOperations.getBooksByCategory(object, category);

        Assertions.assertTrue(booksByCategory.contains(book1));
        Assertions.assertFalse(booksByCategory.contains(book2));
    }

    @Test
    public void shouldSortOperations5() {
        Category category = new Category("name");
        Book book = new Book("name", "1");
        book.setCategory(category);
        List<Book> object = new ArrayList<>();
        object.add(book);
        List<Book> booksByCategory = SortOperations.getBooksByCategory(object, category);

        Assertions.assertEquals(booksByCategory.get(0).getCategory(), category);
    }

    @Test
    public void shouldSortOperations6() {
        List<Newspaper> object1 = new ArrayList<>();
        Newspaper news1 = new Newspaper("name1", Instant.now());
        Newspaper news2 = new Newspaper("name2", Instant.parse("2022-12-03T10:15:30.00Z"));
        Newspaper news3 = new Newspaper("name3", Instant.parse("2021-12-03T10:15:30.00Z"));
        object1.add(news2);
        object1.add(news1);
        object1.add(news3);
        List<Newspaper> actual = SortOperations.sortNewspapersByDate(object1);

        Assertions.assertSame(actual.get(0), news1);
        Assertions.assertSame(actual.get(1), news2);
        Assertions.assertSame(actual.get(2), news3);
    }

    @Test
    public void shouldSortOperations7() {
        List<Newspaper> news = new ArrayList<>();
        List<Newspaper> actual = SortOperations.sortNewspapersByDate(news);

        Assertions.assertTrue(actual.isEmpty());
    }

}