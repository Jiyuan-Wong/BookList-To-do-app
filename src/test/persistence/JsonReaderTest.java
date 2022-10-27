package persistence;


import model.BookList;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            BookList wr = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyWorkRoom.json");
        try {
            BookList wr = reader.read();
            assertEquals("My book list", wr.getListName());
            assertEquals(0, wr.getListSize());
        } catch (IOException e) {
            System.out.println("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/myFile.json");
        try {
            BookList wr = reader.read();
            assertEquals("My book list", wr.getListName());
            } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}