package persistence;

import jdk.jfr.Category;
import model.Books;
import model.Booklist;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkBooks(String name, String type, String category, Books books) {
        assertEquals(name,books.getBookName());
        assertEquals(category, books.getCategoryOfTheBook());
        assertEquals(type,books.getBookType());
    }
}
