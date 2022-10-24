package ui;
// User interface

import model.Booklist;
import model.Books;

import java.util.Scanner;

public class TellerApp {

    static Booklist booklist = new Booklist("new book list");

    public static void main(String[] args) {
        runapp();
    }

    public TellerApp() {
        runapp();
    }

    public static void runapp() {
        boolean keepgoing = true;
        while (keepgoing) {
            String optionEntered = userinterface();
            if (optionEntered.equals("1")) {
                addMethod();
            } else if (optionEntered.equals("2")) {
                view();
            } else if (optionEntered.equals("3")) {
                mark();
            } else if (optionEntered.equals("4")) {
                viewSingleBook();
            } else if (optionEntered.equals("5")) {
                remove();
            } else if (optionEntered.equals("6")) {
                keepgoing = false;
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid input, please try again! ");
            }
        }
    }


    public static String userinterface() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to 'Reading list helper'! How can I help you?");
        System.out.println("1. Add a book to your book list.");
        System.out.println("2. View your book list.");
        System.out.println("3. Mark a book as read.");
        System.out.println("4. View your book.");
        System.out.println("5. Remove a book from your book list.");
        System.out.println("6. Quit");
        return in.nextLine();
    }

    public static void addMethod() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name, type and category ");
        String name = in.nextLine();
        String type = in.nextLine();
        String category = in.nextLine();
        Books book = new Books(name, type, category);
        booklist.addBook(book);
        System.out.println("The book has been added.");
        userinterface();
    }

    public static void view() {
        for (int i = 0; i < booklist.getListSize(); i++) {
            System.out.println("Name: " + booklist.getIndex(i).getBookName() + " Type: "
                    + booklist.getIndex(i).getBookType() + " Category: " + booklist.getIndex(i).getCategoryOfTheBook());
        }
    }

    public static void mark() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the index of the book you want to mark: ");
        int index = in.nextInt();
        if (0 < booklist.getListSize() && index <= booklist.getListSize()) {
            booklist.getIndex(index).read();
            System.out.println("The book has been read");
        }
    }

    public static void viewSingleBook() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the index of the book you want to view: ");
        int index = in.nextInt();
        if (0 < booklist.getListSize() && index <= booklist.getListSize()) {
            System.out.println("Name: " + booklist.getIndex(index).getBookName() + " Type: "
                    + booklist.getIndex(index).getBookType() + " Category: "
                    + booklist.getIndex(index).getCategoryOfTheBook());
        }
    }

    public static void remove() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the index of the book you want to remove: ");
        int removeIndex = in.nextInt();
        try {
            booklist.removeBook(removeIndex);
            System.out.println("The book have been removed.");
        } catch (Exception e) {
            System.out.println("The name of book you entered can not be found");
        }
    }

}