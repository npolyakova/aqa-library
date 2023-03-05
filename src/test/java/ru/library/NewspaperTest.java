package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.Instant;

class NewspaperTest {

    @Test
    public void shouldGetDate() {
        final Newspaper newspaper = new Newspaper("newspaperName", Instant.parse("2017-02-03T10:37:30.00Z"));

        Assertions.assertEquals(newspaper.getDate(), Instant.parse("2017-02-03T10:37:30.00Z"));
    }

}