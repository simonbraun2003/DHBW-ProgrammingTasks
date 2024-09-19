package de.dhbw.java.exercise.ui.paint;

import javax.swing.*;
import java.awt.*;

public class Election extends JComponent {//ToDo: Aufgabe nicht erledigt!

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.decode("#ADD8E6"));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.decode("#1E90FF"));
        g.fillRect(0, 0, getWidth(), (getHeight()/100)*8);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Helvetica", Font.BOLD, 20));
        g.drawString("Bundestagswahl 2021", 20, (getHeight()/100)*5);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Election");
        frame.add(new Election());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
