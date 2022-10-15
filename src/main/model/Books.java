package model;

public class Books {

    private final String bookName;
    private final String bookType;
    private final String categoryOfTheBook;
    private double progressInPercent;
    private boolean haveBeenRead;
    private boolean haveBeenReadThrough;


    public Books(String name, String type, String category) {
        this.bookName = name;
        this.bookType = type;
        this.categoryOfTheBook = category;
        this.progressInPercent = 0;
        this.haveBeenRead = false;
        this.haveBeenReadThrough = false;

    }

    public String getBookName() {
        return bookName;
    }

    public String getBookType() {
        return bookType;
    }

    public String getCategoryOfTheBook() {
        return categoryOfTheBook;
    }

    public double getProgressInPercent() {
        return progressInPercent;
    }

    public boolean getHaveBeenRead() {
        return haveBeenRead;
    }

    public boolean isHaveBeenReadThrough() {
        return haveBeenReadThrough;
    }

    public void read() {
        progressInPercent += 1;
        haveBeenRead = true;
        if (progressInPercent >= 100) {
            haveBeenReadThrough = true;
        }
    }


}
