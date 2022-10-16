package model;

// Represents a book list that will be added by books
import java.util.ArrayList;
import java.util.List;

public class Booklist {

    //Fields to represent name of book list and itself
    private final String listName;
    private final ArrayList<Books> booklist = new ArrayList<Books>();


    // REQUIRES: listName != null
    // MODIFIES: this
    // EFFECTS: returns the name of the book
    public Booklist(String listName) {
        this.listName = listName;
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

    public Books getIndex(int index) {
        return booklist.get(index);
    }


    // EFFECTS: returns the name of the book list
    public String getListName() {
        return listName;
    }


    // EFFECTS: returns the size of the book list
    public int getListSize() {
        return booklist.size();
    }

}
