package de.dhbw.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

public class CurrencyCalculator {

    public static void main(String[] args) {
        //Anlegen der Komponenten
        JFrame frame;
        JButton eurUsd;
        JButton usdEur;
        JButton cancel;
        JTextField input;

        //Initialisieren
        frame = new JFrame();
        eurUsd = new JButton("EUR -> USD");
        usdEur = new JButton("USD -> EUR");
        cancel = new JButton("Cancel");
        input = new JTextField();

        frame.setLayout(new BorderLayout());
        frame.setSize(400, 80);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        input.setText("Please enter amount to convert!");
        frame.add(input,BorderLayout.NORTH);
        frame.add(eurUsd,BorderLayout.WEST);
        frame.add(usdEur,BorderLayout.CENTER);
        frame.add(cancel,BorderLayout.EAST);

        //Fenster anzeigen
        frame.setVisible(true);

    }
}
