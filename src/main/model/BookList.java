package model;


// Represents a book list that will be added by books
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookList implements Writable {


    //Fields to represent name of book list and itself
    private final String listName;
    private final ArrayList<Books> bookList;


    // REQUIRES: listName != null
    // MODIFIES: this
    // EFFECTS: returns the name of the book
    public BookList(String listName) {
        this.listName = listName;
        bookList = new ArrayList<>();
    }


    // EFFECTS: returns the name of the book list
    public String getListName() {
        return listName;
    }


    // EFFECTS: returns an unmodifiable list of books in this book list
    public List<Books> getBookList() {
        return Collections.unmodifiableList(bookList);
    }


    // REQUIRES: book != null
    // MODIFIES: this
    // EFFECTS: add the book in the book list named booklist
    public List<Books> addBook(Books book) {
        EventLog.getInstance().logEvent(new Event("Added book in the book list: " + book.getBookName()));
        bookList.add(book);
        return null;
    }



    // REQUIRES: book != null
    // MODIFIES: this
    // EFFECTS: remove the book from the book list named booklist by search the name
    public void removeBook(int index) {
        EventLog.getInstance().logEvent(
                new Event("Removed book in the book list: " + bookList.get(index).getBookName()));
        bookList.remove(index);
    }


    // REQUIRES: book != null
    // MODIFIES: this
    // EFFECTS: get the index of the book in the book list
    public Books getIndex(int index) {
        return bookList.get(index);
    }


    // EFFECTS: returns the size of the book list
    public int getListSize() {
        return bookList.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", listName);
        json.put("thingies", thingiesToJson());
        EventLog.getInstance().logEvent(
                new Event("The current book list have been saved, list name: " + bookList.toString()));
        return json;
    }

    // EFFECTS: returns things in this book list as a JSON array
    private JSONArray thingiesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Books t : bookList) {
            jsonArray.put(t.toJson());
        }
        return jsonArray;
    }

}
