package ru.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.Instant;

class NewspaperTest {

    @Test
    public void shouldGetDate() {
        final Newspaper newspaper = new Newspaper ("Name", Instant.now());

        Assertions.assertNotNull(newspaper.getDate());
    }

}