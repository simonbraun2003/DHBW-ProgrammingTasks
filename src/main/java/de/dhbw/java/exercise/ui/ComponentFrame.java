package de.dhbw.java.exercise.ui;

import javax.swing.*;
import java.awt.*;

public class ComponentFrame {//Info: Bekannte Befehle für verschiedene Swing-Elemente
    public static void main(String[] args) {

        //Initalisierung eines JFrame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Several basic Swing components");
        frame.setLayout(new FlowLayout());
        frame.setSize(600, 100);
        frame.setLocationRelativeTo(null);

        //Initalisierung JLabel
        JLabel label = new JLabel();
        label.setText("JLabel");
        frame.add(label);

        //Initalisierung JTextField
        JTextField textField = new JTextField();
        textField.setText("JTextField");
        frame.add(textField);

        //Initailisierung JPasswordField
        JPasswordField passwordField = new JPasswordField();
        passwordField.setText("JPasswordField");
        frame.add(passwordField);

        //Initalisierung JButton
        JButton button = new JButton();
        button.setText("JButton");
        frame.add(button);

        //Initalisierung JToggleButton
        JToggleButton toggleButton = new JToggleButton();
        toggleButton.setText("JToggleButton");
        frame.add(toggleButton);

        //Initalisierung JCheckBox
        JCheckBox checkBox = new JCheckBox();
        checkBox.setText("JCheckBox");
        frame.add(checkBox);

        //Initalisierung JComboBox
        JComboBox <String> comboBox = new JComboBox<>();
        comboBox.addItem("Item1");
        comboBox.addItem("Item2");
        comboBox.addItem("Item3");
        frame.add(comboBox);

        //Initalisierung JRadioButton(Group)
        JRadioButton radioButton1 = new JRadioButton();
        radioButton1.setText("RadioButton-1");
        frame.add(radioButton1);
        JRadioButton radioButton2 = new JRadioButton();
        radioButton2.setText("RadioButton-2");
        frame.add(radioButton2);
        JRadioButton radioButton3 = new JRadioButton();
        radioButton3.setText("RadioButton-3");
        frame.add(radioButton3);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        //JFrame mit Komponenten sichtbar machen
        frame.setVisible(true);
    }
}
