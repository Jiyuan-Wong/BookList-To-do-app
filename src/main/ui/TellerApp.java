package ui;

import model.Books;

import java.util.ArrayList;
import java.util.Scanner;

public class TellerApp {

    ArrayList<Books> booklist = new ArrayList<>();

    public void main(String[] args) {
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
            userinterface();
        }
    }


    public int userinterface() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to 'Reading list helper'! How can I help you?");
        System.out.println("1. Add a book to your booklist.");
        System.out.println("2. View your booklist.");
        System.out.println("3. Mark a book as read.");
        System.out.println("4. View your book.");
        System.out.println("5. Remove a book from your booklist.");
        System.out.println("6. Quit");
        return in.nextInt();
    }

    public void addMethod() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name, type and catrgory ");
        String name = in.nextLine();
        String type = in.nextLine();
        String category = in.nextLine();
        Books book = new Books(name, type, category);
        booklist.add(book);
        System.out.println("The book has been added.");
    }

    public void view() {
        for (int i = 0; i < booklist.size(); i++) {
            System.out.println(booklist.get(i) + "  ");
        }
    }

    public void mark() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the index of the book you want to mark: ");
        int index = in.nextInt();
        booklist.get(index).read();
        System.out.println("The book has been read");
    }

    public void viewSingleBook() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the index of the book you want to view: ");
        int index = in.nextInt();
        booklist.get(index);
    }

    public void remove() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the index of the book you want to remove: ");
        int index = in.nextInt();
        booklist.remove(index);
        System.out.println("The book have been removed.");
    }

}






