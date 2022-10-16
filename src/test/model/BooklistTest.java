package model;

// Test the methods in class Booklist are working
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BooklistTest {
    private Booklist booklist;
    private Books book1;

    @BeforeEach
    void runBefore() {
        booklist = new Booklist("Booklist1");
        book1 = new Books("Discrete Mathematics and Its Applications",
                "e-book", "books for study");
    }

    @Test
    void testAddBook() {
        List<Books> book = booklist.addBook(book1);
        assertEquals(1,booklist.getListSize());
    }

    @Test
    void testRemoveBook() {
        booklist.removeBook(0);
        assertEquals(0,booklist.getListSize());
    }

    @Test
    void testBooklist() {
        assertEquals("Booklist1", booklist.getListName());
    }

}
