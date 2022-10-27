package model;

// Test the methods in class Books are working
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooksTest {
    private Books book1;

    @BeforeEach
    void runBefore() {
        book1 = new Books("Discrete Mathematics and Its Applications",
                "e-book", "books for study");
    }

    @Test
    void testConstructor() {
        assertEquals("Discrete Mathematics and Its Applications", book1.getBookName());
        assertEquals("e-book", book1.getBookType());
        assertEquals("books for study", book1.getCategoryOfTheBook());
        assertEquals(0, book1.getProgressInPercent());
        assertFalse(book1.getHaveBeenRead());
        assertFalse(book1.isHaveBeenReadThrough());
    }

    @Test
    void testRead() {
        assertFalse(book1.getHaveBeenRead());
        assertFalse(book1.isHaveBeenReadThrough());
        book1.read();
        assertEquals(1, book1.getProgressInPercent());
        assertTrue(book1.getHaveBeenRead());
        assertFalse(book1.isHaveBeenReadThrough());
        for (int i = 0; i < 99; i++) {
            book1.read();
        }
        assertTrue(book1.getHaveBeenRead());
        assertTrue(book1.isHaveBeenReadThrough());
        assertEquals(100, book1.getProgressInPercent());


    }

}