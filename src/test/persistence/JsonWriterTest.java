package persistence;

import model.Booklist;
import model.Books;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Booklist bl = new Booklist("My book list");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
            //System.out.println("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Booklist bl = new Booklist("My book list");
            JsonWriter writer = new JsonWriter("./data/myFile.json");
            writer.open();
            writer.write(bl);
            writer.close();

            JsonReader reader = new JsonReader("./data/myFile.json");
            bl = reader.read();
            assertEquals("My book list", bl.getListName());
            assertEquals(0, bl.getListSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Booklist bl = new Booklist("My book list");
            bl.addBook(new Books("name1", "type1", "category1"));
            bl.addBook(new Books("name2", "type2", "category2"));
            JsonWriter writer = new JsonWriter("./data/myFile.json");
            writer.open();
            writer.write(bl);
            writer.close();

            JsonReader reader = new JsonReader("./data/myFile.json");
            bl = reader.read();
            assertEquals("My book list", bl.getListName());
            List<Books> booksList = bl.getBookList();
            assertEquals(2, booksList.size());
            checkBooks("name1", "type1", "category1", booksList.get(0));
            checkBooks("name2", "type2", "category2", booksList.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
