package model;

public class Books {

    private String bookName;
    private String bookType;
    private String categoryOfTheBook;
    private double progressInPercent;
    private boolean haveBeenRead;
    private boolean haveBeenReadThrough;

    public Books(String bookName, String bookType, String categoryOfTheBook,
                 double progressInPercent, boolean haveBeenRead, boolean haveBeenReadThrough) {
        this.bookName = bookName;
        this.bookType = bookType;
        this.categoryOfTheBook = categoryOfTheBook;
        this.progressInPercent = progressInPercent;
        this.haveBeenRead = haveBeenRead;
        this.haveBeenReadThrough = haveBeenReadThrough;
    }

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
        if (progressInPercent > 0) {
            haveBeenRead = true;
            if (progressInPercent >= 100) {
                haveBeenReadThrough = true;
            }
        }
    }


}
