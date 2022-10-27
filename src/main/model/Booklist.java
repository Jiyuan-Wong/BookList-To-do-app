package model;

// Represents a book list that will be added by books
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Booklist implements Writable {


    //Fields to represent name of book list and itself
    private final String listName;
    private final ArrayList<Books> booklist;


    // REQUIRES: listName != null
    // MODIFIES: this
    // EFFECTS: returns the name of the book
    public Booklist(String listName) {
        this.listName = listName;
        booklist = new ArrayList<>();
    }


    // EFFECTS: returns the name of the book list
    public String getListName() {
        return listName;
    }


    // EFFECTS: returns an unmodifiable list of books in this book list
    public List<Books> getBookList() {
        return Collections.unmodifiableList(booklist);
    }


    // REQUIRES: book != null
    // MODIFIES: this
    // EFFECTS: add the book in the book list named booklist
    public List<Books> addBook(Books book) {
        booklist.add(book);
        return null;
    }


    // REQUIRES: book != null
    // MODIFIES: this
    // EFFECTS: remove the book from the book list named booklist by search the name
    public void removeBook(int index) {
        booklist.remove(index);
    }


    // REQUIRES: book != null
    // MODIFIES: this
    // EFFECTS: get the index of the book in the book list
    public Books getIndex(int index) {
        return booklist.get(index);
    }


    // EFFECTS: returns the size of the book list
    public int getListSize() {
        return booklist.size();
    }

    //@Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", listName);
        json.put("thingies", thingiesToJson());
        return json;
    }

    private JSONArray thingiesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Books t : booklist) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }

}
