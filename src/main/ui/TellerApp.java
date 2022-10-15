package ui;

import model.Booklist;
import model.Books;

import java.util.ArrayList;
import java.util.Scanner;

public class TellerApp {
    ArrayList<Books> booklist = new ArrayList<>();


    public void main(String[] args) {
        int num = userinterface();
        if (num == 1) {
            addMethod();
        }
    }


    public static int userinterface() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to 'Reading list helper'! How can I help you?");
        System.out.println("1. Add a book to your booklist.");
        System.out.println("2. View your booklist.");
        System.out.println("3. Mark a book as read.");
        System.out.println("4. View your book.");
        System.out.println("5. Remove a book from your booklist.");
        System.out.println("6. Read a book.");
        System.out.println("7. Quit");
        int optionEntered = in.nextInt();
        return optionEntered;
    }

    public void addMethod() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name, type and catrgory ");
        String name = in.nextLine();
        String type = in.nextLine();
        String category = in.nextLine();
        Books book = new Books(name, type,category);
        booklist.add(book);
        System.out.println("The book has been read.");
    }


}
