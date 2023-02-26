package example;

import ru.library.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static ru.library.GenerateUtils.generateSomeBooks;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Book> books = new ArrayList<>();
         books = generateSomeBooks(random.nextInt(3,6));
    }
}
