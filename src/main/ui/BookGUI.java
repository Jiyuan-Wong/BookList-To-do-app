package ui;

import model.BookList;
import model.Books;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BookGUI implements ActionListener {
    private static BookList booklist = new BookList("list name");

    private JLabel label = new JLabel("Reading list helper");
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();

    private JTextField textField;

    private static final String JSON_STORE = "./data/myFile.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    JButton btn = new JButton("view current book list");
    JButton btn2 = new JButton("add book to book list");
    JButton botton2 = new JButton("saves current book list");
    JButton botton3 = new JButton("loads current book list");
    final JTextArea textArea = new JTextArea(5, 10);


    public BookGUI() {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNewWindow(frame);
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBookNewWindow(frame);
            }
        });
        botton2.addActionListener(this::save);
        botton3.addActionListener(this::load);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0,1));
        textArea.setLineWrap(true);
        addThingsToFrame();

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }


    public void addThingsToFrame() {
        panel.add(textArea);
        panel.add(btn2);
        panel.add(btn);
        panel.add(botton2);
        panel.add(botton3);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Reading list helper");
        frame.pack();
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Ohhhhhh");
    }


    public void save(ActionEvent event) {
        try {
            jsonWriter.open();
            jsonWriter.write(booklist);
            jsonWriter.close();
            textArea.append("Saved " + booklist.getListName() + " to " + JSON_STORE + "\n");
        } catch (FileNotFoundException e) {
            textArea.append("Unable to write to file: " + JSON_STORE + "\n");
        }
        textArea.append("This book list have been saved\n");
    }

    public void load(ActionEvent event) {
        try {
            booklist = jsonReader.read();
            textArea.append("Loaded " + booklist.getListName() + " from " + JSON_STORE + "\n");
        } catch (IOException e) {
            textArea.append("Unable to read from file: " + JSON_STORE + "\n");
        }
        textArea.append("This book list have been loaded\n");
    }

    private static final JLabel name = new JLabel("Book name: ");
    private static final JTextField userName = new JTextField(20);
    private static final JLabel type = new JLabel("Book type: ");
    private static final JTextField userType = new JTextField();
    private static final JLabel category = new JLabel("Book category: ");
    private static final JTextField userCate = new JTextField();
    private static final JButton button = new JButton("Submit");
    private static final JLabel success = new JLabel("");

    JFrame newJFrame = new JFrame("Enter the name, type and category: ");
    JPanel jpanel = new JPanel(new GridLayout(4, 2));


    public void addBookNewWindow(JFrame addNewWindow) {
        jpanel.setSize(500, 500);
        newJFrame.setSize(2500, 2500);
        newJFrame.setLocationRelativeTo(addNewWindow);
        newJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        newJFrame.setResizable(true);

        newJFrame.setBounds(10, 20, 80, 25);
        name.setBounds(10, 50, 80, 25);
        userName.setBounds(100, 50, 165, 25);
        type.setBounds(10, 80, 80, 25);
        userType.setBounds(100, 80, 165, 25);
        category.setBounds(10, 110, 80, 25);
        userCate.setBounds(100, 110, 165, 25);
        button.setBounds(10, 140, 80, 25);
        success.setBounds(10, 170, 300, 25);

        button.addActionListener(this:: add);
        addThingsToFrame2();
    }

    public void addThingsToFrame2() {
        jpanel.add(name);
        jpanel.add(userName);
        jpanel.add(type);
        jpanel.add(userType);
        jpanel.add(category);
        jpanel.add(userCate);
        jpanel.add(button);
        jpanel.add(success);
        newJFrame.setContentPane(jpanel);
        newJFrame.setVisible(true);
    }



    private void add(ActionEvent event) {
        String realName = userName.getText();
        String realType = userType.getText();
        String realCate = userCate.getText();
        booklist.addBook(new Books(realName, realType, realCate));
        textArea.append("New book have been added!\n");
    }


    public  void showNewWindow(JFrame relativeWindow) {
        JFrame newJFrame = new JFrame("view the book list");
        newJFrame.setSize(500, 500);
        newJFrame.setLocationRelativeTo(relativeWindow);
        newJFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        newJFrame.setResizable(true);
        JPanel panel = new JPanel(new GridLayout(1, 1));
        int size = booklist.getListSize();
        for (int i = 0; i < size; i++) {
            textArea.append("Name: " + booklist.getIndex(i).getBookName() + " Type: "
                    + booklist.getIndex(i).getBookType() + " Category: "
                    + booklist.getIndex(i).getCategoryOfTheBook() + "\n");
        }
        JLabel label = new JLabel("Books in the list can be seen in the mean menu: \n");
        label.setFont(new Font(null, Font.PLAIN, 25));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        panel.add(label);
        JLabel label111 = new JLabel();
        label111.setIcon(new ImageIcon("data/tobs.jpg"));
        label111.setBounds(2,2,2,2);
        panel.add(label111);
        newJFrame.setContentPane(panel);
        newJFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new BookGUI();
    }
}


