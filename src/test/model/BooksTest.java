package model;

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
        assertEquals(false, book1.getHaveBeenRead());
        assertEquals(false, book1.isHaveBeenReadThrough());
    }

    @Test
    void testRead() {
        assertEquals(false, book1.getHaveBeenRead());
        assertEquals(false, book1.isHaveBeenReadThrough());
        book1.read();
        assertEquals(1,book1.getProgressInPercent());
        assertEquals(true, book1.getHaveBeenRead());
        assertEquals(false, book1.isHaveBeenReadThrough());
        for(int i = 0; i < 99; i++) {
            book1.read();
        }
        assertEquals(true, book1.getHaveBeenRead());
        assertEquals(true, book1.isHaveBeenReadThrough());
        assertEquals(100, book1.getProgressInPercent());

    }

    @Test
    void testBooks() {

    }



}