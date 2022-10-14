package model;

import java.util.ArrayList;

public class Booklist {
    private ArrayList<Books> booklist = new ArrayList<Books>();

    private static Books book1 = new Books("Discrete Mathematics and Its Applications",
            "e-book", "books for study");
    private static Books book2 = new Books("The old man and the sea", "real_book", "book for fun");

    protected void addInitialBooksToBooklist() {
        booklist.add(book1);
        booklist.add(book2);
    }

    protected void listAllBooksInBooklist() {
        System.out.println(" NAME\t\t|\tTYPE\t|\tCATEGORY\t|");
        System.out.println("______________________________________________________________________________");
        for (int i = 0; i < booklist.size(); i++) {
            System.out.println(booklist.get(i).getBookName() + booklist.get(i).getBookType()
                    + booklist.get(i).getCategoryOfTheBook());
        }
    }

    protected void listAllBookNamesInBooklist() {
        for (int i = 0; i < booklist.size(); i++) {
            System.out.println(booklist.get(i).getBookName());
        }
    }

    protected void listAllBookTypeInBooklist() {
        for (int i = 0; i < booklist.size(); i++) {
            System.out.println(booklist.get(i).getBookType());
        }
    }

    protected void listAllBookCategoryInBooklist() {
        for (int i = 0; i < booklist.size(); i++) {
            System.out.println(booklist.get(i).getCategoryOfTheBook());
        }
    }
}
