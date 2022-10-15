package model;

import java.util.ArrayList;
import java.util.List;

public class Booklist {

    private String listName;
    private ArrayList<Books> booklist = new ArrayList<Books>();

    public Booklist(String listName) {
        this.listName = listName;
    }

    public List<Books> addBook(Books book) {
        booklist.add(book);
        return null;
    }

    public void removeBook(Books book) {
        booklist.remove(book);
    }

    public String getListName() {
        return listName;
    }

    public int getListSize() {
        return booklist.size();
    }

}
