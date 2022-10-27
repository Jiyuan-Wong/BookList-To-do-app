package persistence;

import model.BookList;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Books;
import org.json.*;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public BookList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private static String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private BookList parseWorkRoom(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        BookList bl = new BookList(name);
        addThingies(bl, jsonObject);
        return bl;
    }

    // MODIFIES: bl
    // EFFECTS: parses thingies from JSON object and adds them to workroom
    private void addThingies(BookList bl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("thingies");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addThingy(bl, nextThingy);
        }
    }

    // MODIFIES: bl
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addThingy(BookList bl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        String category = jsonObject.getString("category");
        String type = jsonObject.getString("type");
        Books thingy = new Books(name, type, category);
        bl.addBook(thingy);
    }
}

