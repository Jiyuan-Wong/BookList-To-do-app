package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a book that will be listed in the book list
public class Books implements Writable {

    //Fields to represent name, type, category, progress and the condition about reading of the book
    private final String bookName;
    private final String bookType;
    private final String categoryOfTheBook;
    private double progressInPercent;
    private boolean haveBeenRead;
    private boolean haveBeenReadThrough;


    // REQUIRES: progressOfTheBook = 0, haveBeenRead = false, haveBeenReadThrough = false
    // EFFECTS: constructs the book with given initial name, type, category, progress and the condition about reading
    public Books(String name, String type, String category) {
        this.bookName = name;
        this.bookType = type;
        this.categoryOfTheBook = category;
        this.progressInPercent = 0;
        this.haveBeenRead = false;
        this.haveBeenReadThrough = false;

    }


    // EFFECTS: returns the name of the book
    public String getBookName() {
        return bookName;
    }


    // EFFECTS: returns the type of the book
    public String getBookType() {
        return bookType;
    }


    // EFFECTS: returns the category of the book
    public String getCategoryOfTheBook() {
        return categoryOfTheBook;
    }


    // EFFECTS: returns the progress of the book (in percent)
    public double getProgressInPercent() {
        return progressInPercent;
    }


    // EFFECTS: returns that is the book being read or not
    public boolean getHaveBeenRead() {
        return haveBeenRead;
    }


    // EFFECTS: returns that is the book being read through or not
    public boolean isHaveBeenReadThrough() {
        return haveBeenReadThrough;
    }


    // REQUIRES: 0 <= progressInPercent <= 100
    // MODIFIES: this
    // EFFECTS: the progress of the book is not 100
    //            - the progress add by 1
    //            - the boolean haveBeenRead is true instead of false
    //                - if after adding the progress turns to 100
    //            - the boolean haveBeenReadThrough is true instead of false
    public void read() {
        progressInPercent += 1;
        haveBeenRead = true;
        if (progressInPercent >= 100) {
            haveBeenReadThrough = true;
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", bookName);
        json.put("type", bookType);
        json.put("category", categoryOfTheBook);
        return json;
    }


}