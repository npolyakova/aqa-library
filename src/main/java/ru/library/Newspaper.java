package ru.library;

import java.time.Instant;

public class Newspaper extends Book {

    private Instant date;

    public Instant getDate() {
        return this.date;
    }

    public Newspaper(String name, Instant date) {
        super(name, null);
        this.date = date;
    }
}
