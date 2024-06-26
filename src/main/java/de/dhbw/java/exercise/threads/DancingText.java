package de.dhbw.java.exercise.threads;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DancingText extends JFrame implements Runnable {

    private int abstand = 5;

    private JLabel[] letterLabel = new JLabel[11];
    private String[] letters = {"D", "A", "N", "C", "I", "N", "G", "T", "E", "X", "T"};

    Random rand = new Random();

    public DancingText() {
        this.setTitle("Dancing Text");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(0, letterLabel.length, abstand, abstand));
        this.setSize(350, 100);
        this.setLocationRelativeTo(null);

        createLetterLabel();

        this.setVisible(true);
        run();
    }

    public static void main(String[] args) {
        DancingText dt = new DancingText();
    }

    private void createLetterLabel() {
        for (int i = 0; i < letterLabel.length; i++) {
            letterLabel[i] = new JLabel(letters[i]);
            letterLabel[i].setHorizontalAlignment(JLabel.CENTER);
            letterLabel[i].setFont(new Font("Arial", Font.BOLD, 20));
            this.add(letterLabel[i]);
        }
    }

    private void changeText() {
        Random randAlignment = new Random();
        for (int i = 0; i < letterLabel.length; i++) {
            int r = rand.nextInt(256);
            int b = rand.nextInt(256);
            int g = rand.nextInt(256);
            letterLabel[i].setForeground(new Color(r, b, g));
            int x = rand.nextInt(12);
            if (x < 5) {
                letterLabel[i].setVerticalAlignment(JLabel.TOP);
                letterLabel[i].setFont(new Font("Arial", Font.BOLD, 17));
            } else if (x > 9) {
                letterLabel[i].setVerticalAlignment(JLabel.CENTER);
                letterLabel[i].setFont(new Font("Plain", Font.ITALIC, 12));

            } else {
                //letterLabel[i].setVerticalAlignment(JLabel.BOTTOM);
                letterLabel[i].setFont(new Font("Monospaced", Font.PLAIN, 15));

            }
        }
    }


    @Override
    public void run() {
        while (true) {
            changeText();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
