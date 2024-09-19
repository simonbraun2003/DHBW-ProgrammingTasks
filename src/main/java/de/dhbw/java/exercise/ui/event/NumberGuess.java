package de.dhbw.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NumberGuess extends JFrame {

    File dir = new File("C:\\Users\\simon\\Documents\\GitHub\\DHBW-ProgrammingTasks\\myDir");
    File resultFile = new File(dir,"numberGuessResults.txt");

    int numberToGuess;
    int attemptCount;

    JPanel playerPanel = new JPanel();
    JPanel numberPanel = new JPanel();
    JPanel btnPanel = new JPanel();
    JPanel infoPanel = new JPanel();

    JTextField nameField = new JTextField(30);
    JTextField guessField = new JTextField(15);

    JButton newGameBtn = new JButton("New Game");
    JButton okBtn = new JButton("OK");
    JButton bestPlayerBtn = new JButton("Best Player");
    JButton exitBtn = new JButton("Exit");

    JTextField resultField = new JTextField(50);

    public NumberGuess() {
        this.setTitle("Number Guessing Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(4,1));
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);

        initializeGame();

        newGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initializeGame();
            }
        });

        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                attemptCount++;
                play();
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        playerPanel.setLayout(new FlowLayout());
        playerPanel.add(new JLabel("Player Name "));
        playerPanel.add(nameField);
        this.add(playerPanel);

        numberPanel.setLayout(new FlowLayout());
        numberPanel.add(new JLabel("Enter number between 1 and 1000 "));
        numberPanel.add(guessField);
        this.add(numberPanel);

        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(newGameBtn);
        btnPanel.add(okBtn);
        btnPanel.add(bestPlayerBtn);
        btnPanel.add(exitBtn);
        this.add(btnPanel);

        infoPanel.add(resultField);
        this.add(infoPanel);

        this.setVisible(true);
    }

    public void initializeGame() {
        numberToGuess = (int) (Math.random()*1000);
        attemptCount = 0;
    }

    public void play(){
        String eingabe = guessField.getText();
        try{
            int guess = Integer.parseInt(guessField.getText());
            if(guess == numberToGuess){
                //Abspeichern des Palindrom in Text-Datei
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(resultFile, true))){
                    bw.write( nameField.getText() + " mit " + attemptCount + " Versuche(n) für die Zahl " + numberToGuess);
                    bw.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                resultField.setText("Good Job!");
                initializeGame();
            }else if(guess > numberToGuess){
                resultField.setText("Attempt #" + attemptCount + ": " + guess + " => too big!");
            }else {
                resultField.setText("Attempt #" + attemptCount + ": " + guess + " => too small!");
            }
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Not a number!!");
        }

    }

    public static void main(String[] args) {
        new NumberGuess();
    }
}
