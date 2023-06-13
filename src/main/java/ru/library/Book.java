package ru.library;

public class Book {

    private String name;

    private String author;

    private Category category;

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        if (category.getName() = null) {
            this.category = category;
        } else {
            System.out.println("Не получилось привязать категорию, категория не содержит имени");
        }
    }

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }
}
