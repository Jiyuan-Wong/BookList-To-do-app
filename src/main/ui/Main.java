package ui;

import java.io.FileNotFoundException;

// Open a new TellerApp every time user open the application
public class Main {
    public static void main(String[] args) {
        try {
            new TellerApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}