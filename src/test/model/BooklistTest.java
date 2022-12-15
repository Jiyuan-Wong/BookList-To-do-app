package model;

// Test the methods in class Booklist are working
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BooklistTest {
    private BookList booklist;
    private Books book1;

    @BeforeEach
    void runBefore() {
        booklist = new BookList("Booklist1");
        book1 = new Books("Discrete Mathematics and Its Applications",
                "e-book", "books for study");
    }

    @Test
    void testAddBook() {
        booklist.addBook(book1);
        assertEquals(1,booklist.getListSize());
    }


    @Test
    void testgetIndex() {
        booklist.addBook(book1);
        assertEquals(1,booklist.getListSize());
        assertEquals(book1,booklist.getIndex(0));
    }


    @Test
    void testRemoveBook() {
        assertEquals(0,booklist.getListSize());
        booklist.addBook(book1);
        assertEquals(1,booklist.getListSize());
        booklist.removeBook(0);
        assertEquals(0, booklist.getListSize());
    }

    @Test
    void testBooklist() {
        assertEquals("Booklist1", booklist.getListName());
    }

    @Test
    void testgetBooklist() {

    }
}
