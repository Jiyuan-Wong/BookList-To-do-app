package ui;

import model.Books;

import java.util.ArrayList;
import java.util.Scanner;

public class TellerApp {

    public static final ArrayList<Books> booklist = new ArrayList<>();

    public static void main(String[] args) {
        main();
    }

    public static void main() {
        int num = userinterface();
        if (num == 1) {
            addMethod();
        } else if (num == 2) {
            view();
        } else if (num == 3) {
            mark();
        } else if (num == 4) {
            viewSingleBook();
        } else if (num == 5) {
            remove();
        } else if (num == 6) {
            System.out.println("Goodbye!");
        } else {
            System.out.println("Invalid input, please try again! ");
        }
    }


    public static int userinterface() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to 'Reading list helper'! How can I help you?");
        System.out.println("1. Add a book to your book list.");
        System.out.println("2. View your book list.");
        System.out.println("3. Mark a book as read.");
        System.out.println("4. View your book.");
        System.out.println("5. Remove a book from your book list.");
        System.out.println("6. Quit");
        return in.nextInt();
    }

    public static void addMethod() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name, type and category ");
        String name = in.nextLine();
        String type = in.nextLine();
        String category = in.nextLine();
        Books book = new Books(name, type, category);
        booklist.add(book);
        System.out.println("The book has been added.");
        userinterface();
    }

    public static void view() {
        for (Books books : booklist) {
            System.out.println("Name: " + books.getBookName() + " Type: "
                    + books.getBookType() + " Category: " + books.getCategoryOfTheBook());
        }
    }

    public static void mark() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the index of the book you want to mark: ");
        int index = in.nextInt();
        if (0 < booklist.size() && index <= booklist.size()) {
            booklist.get(index).read();
            System.out.println("The book has been read");
        }
    }

    public static void viewSingleBook() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the index of the book you want to view: ");
        int index = in.nextInt();
        if (0 < booklist.size() && index <= booklist.size()) {
            System.out.println("Name: " + booklist.get(index).getBookName() + " Type: "
                    + booklist.get(index).getBookType() + " Category: " + booklist.get(index).getCategoryOfTheBook());
        }
    }

    public static void remove() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the index of the book you want to remove: ");
        int index = in.nextInt();
        if (0 < booklist.size() && index <= booklist.size()) {
            booklist.remove(index);
            System.out.println("The book have been removed.");
        }
    }

}