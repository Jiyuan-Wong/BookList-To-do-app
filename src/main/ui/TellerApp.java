package ui;
// User interface

import model.BookList;
import model.Books;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Represents the book list application
public class TellerApp {
    private static final String JSON_STORE = "./data/workroom.json";
    private Scanner input;
    private BookList booklist;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: constructs book list and runs application
    public TellerApp() throws FileNotFoundException {
        input = new Scanner((System.in));
        booklist = new BookList("New Book List");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runapp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    public void runapp() {
        boolean keepgoing = true;
        String command = null;
        input = new Scanner(System.in);
        while (keepgoing) {
            displayMenu();
            command = input.next();
            if (command.equals("8")) {
                keepgoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye!");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("Welcome to 'Reading list helper'! How can I help you?");
        System.out.println("1. Add a book to your book list.");
        System.out.println("2. View your book list.");
        System.out.println("3. Mark a book as read.");
        System.out.println("4. View your book.");
        System.out.println("5. Remove a book from your book list.");
        System.out.println("6. save book list to file");
        System.out.println("7. load book list from file");
        System.out.println("8. Quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("1")) {
            addMethod();
        } else if (command.equals("2")) {
            view();
        } else if (command.equals("3")) {
            mark();
        } else if (command.equals("4")) {
            viewSingleBook();
        } else if (command.equals("5")) {
            remove();
        } else if ((command.equals("6"))) {
            saveWorkRoom();
        } else if ((command.equals("7"))) {
            loadWorkRoom();
        } else {
            System.out.println("Invalid input, please try again! ");
        }
    }

    // EFFECTS: prompts user to select category and returns it
    public void addMethod() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name, type and category ");
        String name = in.nextLine();
        String type = in.nextLine();
        String category = in.nextLine();
        Books book = new Books(name, type, category);
        booklist.addBook(book);
        System.out.println("The book has been added.");
    }

    // MODIFIES: this
    // EFFECTS: views the whole book list
    public void view() {
        for (int i = 0; i < booklist.getListSize(); i++) {
            System.out.println("Name: " + booklist.getIndex(i).getBookName() + " Type: "
                    + booklist.getIndex(i).getBookType() + " Category: " + booklist.getIndex(i).getCategoryOfTheBook());
        }
    }

    // MODIFIES: this
    // EFFECTS: marks a book as read
    public void mark() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the index of the book you want to mark: ");
        int index = in.nextInt();
        if (0 < booklist.getListSize() && index <= booklist.getListSize()) {
            booklist.getIndex(index).read();
            System.out.println("The book has been read");
        }
    }

    // MODIFIES: this
    // EFFECTS: views a particular book in the book list
    public void viewSingleBook() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the index of the book you want to view: ");
        int index = in.nextInt();
        if (0 < booklist.getListSize() && index <= booklist.getListSize()) {
            System.out.println("Name: " + booklist.getIndex(index).getBookName() + " Type: "
                    + booklist.getIndex(index).getBookType() + " Category: "
                    + booklist.getIndex(index).getCategoryOfTheBook());
        }
    }

    // MODIFIES: this
    // EFFECTS: removes the book from the book list
    public void remove() {
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

    // EFFECTS: saves the workroom to file
    private void saveWorkRoom() {
        try {
            jsonWriter.open();
            jsonWriter.write(booklist);
            jsonWriter.close();
            System.out.println("Saved " + booklist.getListName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadWorkRoom() {
        try {
            booklist = jsonReader.read();
            System.out.println("Loaded " + booklist.getListName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

}