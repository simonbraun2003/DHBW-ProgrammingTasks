package de.dhbw.java.exercise.collections.library;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Library extends JFrame {

    private JPanel inputPanel;
    private JLabel[] labels = new JLabel[4];
    private String[] labelNames = {"Title", "Author", "Year", "Publisher"};
    private JTextField[] textFields = new JTextField[4];
    private JPanel listOrderPanel;
    private JLabel orderLabel;
    private JButton[] orderBtns = new JButton[4];
    private JButton saveBtn;

    private File dir = new File("C:\\Users\\simon\\Documents\\GitHub\\DHBW-ProgrammingTasks\\myDir");
    private File palindromesFile = new File(dir,"books.txt");

    public Library() {
        super("Library");
        this.setSize(500, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 4, 5, 5));
        for(int i = 0; i < labels.length; i++ ){
            labels[i] = new JLabel();
            labels[i].setText(labelNames[i]);
            textFields[i] = new JTextField();
            inputPanel.add(labels[i]);
            inputPanel.add(textFields[i]);
        }

        this.add(inputPanel, BorderLayout.NORTH );

        saveBtn = new JButton("Save entry");
        this.add( saveBtn, BorderLayout.CENTER );

        listOrderPanel = new JPanel();
        listOrderPanel.setLayout(new FlowLayout());
        orderLabel = new JLabel("Order output:");
        listOrderPanel.add(orderLabel);
        for(int i = 0; i < orderBtns.length; i++ ){
            orderBtns[i] = new JButton();
            orderBtns[i].setText(labelNames[i]);
            listOrderPanel.add(orderBtns[i]);
        }
        this.add(listOrderPanel, BorderLayout.SOUTH );

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Library();
    }
}
