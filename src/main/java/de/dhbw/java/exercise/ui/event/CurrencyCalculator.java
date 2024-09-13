package de.dhbw.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyCalculator {
    //Anlegen der Komponenten
    JFrame frame;
    JButton eurUsd;
    JButton usdEur;
    JButton cancel;
    JTextField input;

    double amount;

    public CurrencyCalculator() {
        //Initialisieren
        frame = new JFrame();
        eurUsd = new JButton("EUR -> USD");
        usdEur = new JButton("USD -> EUR");
        cancel = new JButton("Cancel");
        input = new JTextField();

        frame.setLayout(new BorderLayout(10, 10));
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        input.setText("Please enter amount to convert!");
        frame.add(input, BorderLayout.NORTH);
        frame.add(eurUsd, BorderLayout.WEST);
        frame.add(usdEur, BorderLayout.CENTER);
        frame.add(cancel, BorderLayout.EAST);

        eventHandler();

        //Fenster anzeigen
        frame.setVisible(true);
    }

    //Steuerung der ausgelösten Events durch jeweiligen Eventhandler
    public void eventHandler() {
        //Euro -> USD
        eurUsd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (checkIfInputIsNum()) {
                    input.setText((amount * 1.11) + ""); //Berechnen des neuen Wertes und Einfügen in Textfeld
                }
            }
        });
        //USD -> EUR
        usdEur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkIfInputIsNum();
                if (checkIfInputIsNum()) {
                    input.setText((amount / 1.11) + ""); //Berechnen des neuen Wertes und Einfügen in Textfeld
                }

            }
        });

        //Abbrechen
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input.setText("Please enter amount to convert!");
            }
        });
    }

    //Überprüfung ob Eingabe des Nutzers regelkonform war
    public boolean checkIfInputIsNum() {
        try {
            amount = Double.parseDouble(input.getText());
            return true;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    frame, ex.getMessage(), "Error please enter a number!", JOptionPane.ERROR_MESSAGE);
            return false;

        }

    }

    //Test-Methode
    public static void main(String[] args) {
        new CurrencyCalculator();
    }
}
