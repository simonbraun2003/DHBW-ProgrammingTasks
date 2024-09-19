package de.dhbw.java.exercise.ui.event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryNumber implements ActionListener { //ToDo: Aufgabe funktioniert nocht nicht so wie sie soll!
    private JToggleButton[] buttons = new JToggleButton[8];
    private ImageIcon imgOff = new ImageIcon(
            "C:\\Users\\simon\\Documents\\GitHub\\DHBW-ProgrammingTasks\\src\\main\\resources\\off.png");
    private ImageIcon imgOn = new ImageIcon(
            "C:\\Users\\simon\\Documents\\GitHub\\DHBW-ProgrammingTasks\\src\\main\\resources\\on.png");
    private JLabel[] labels = new JLabel[8];
    private JLabel resultLabel = new JLabel();
    private int result = 0;

    public BinaryNumber() {
        JFrame frame = new JFrame("Binary Number");
        frame.setSize(750,300);
        frame.setLayout(new GridLayout(3, 1));

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(2, 8, 5, 15));
        JPanel messagePanel = new JPanel();

        for (int i = 0; i < 8; i++){
            buttons[i] = new JToggleButton();
            buttons[i].setIcon(imgOff);
            buttons[i].setSelectedIcon(imgOn);
            buttons[i].addActionListener(this);
            btnPanel.add(buttons[i]);
        }

        for (int i = 7; i >= 0; i--){
            labels[i] = new JLabel("2^" + i);
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            btnPanel.add(labels[i]);
        }

        frame.add(btnPanel);
        frame.add(resultLabel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 8; i++){
            if(buttons[i].isSelected()){
                switch(i){
                    case 0: result += 128; break;
                    case 1: result += 64; break;
                    case 2: result += 32; break;
                    case 3: result += 16; break;
                    case 4: result += 8; break;
                    case 5: result += 4; break;
                    case 6: result += 2; break;
                    case 7: result += 1; break;
                }
            }else{
                switch(i){
                    case 0: result -= 128; break;
                    case 1: result -= 64; break;
                    case 2: result -= 32; break;
                    case 3: result -= 16; break;
                    case 4: result -= 8; break;
                    case 5: result -= 4; break;
                    case 6: result -= 2; break;
                    case 7: result -= 1; break;
                }
            }
        }
        resultLabel.setText("" + result);
    }

    public static void main(String[] args) {
        new BinaryNumber();
    }
}
