package de.dhbw.java.solution.ui.event;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class BMICalculator implements ActionListener {
    private JTextField weightField = new JTextField( 10 );
    private JTextField heightField = new JTextField( 10 );
    private JTextField bmiField = new JTextField( 15 );
    private JTextField messageField = new JTextField( 20 );
    private JRadioButton rbMale = new JRadioButton( "male", true );
    private JRadioButton rbFemale = new JRadioButton( "female", false );
    public BMICalculator() {
        JFrame frame = new JFrame( "BMI Calculator" );
        frame.setLayout( new GridLayout( 6, 1 ) );
        JPanel weightPanel = new JPanel();
        JPanel heightPanel = new JPanel();
        JPanel sexPanel = new JPanel();
        JPanel calcBtnPanel = new JPanel();
        JPanel bmiPanel = new JPanel();
        JPanel messagePanel = new JPanel();
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add( this.rbMale );
        radioButtonGroup.add( this.rbFemale );
        weightPanel.add( new JLabel( "Weight [kg]:" ) );
        weightPanel.add( this.weightField );
        heightPanel.add( new JLabel( "Body height [m]" ) );
        heightPanel.add( this.heightField );
        sexPanel.add( this.rbMale );
        sexPanel.add( this.rbFemale );
        JButton calcBtn = new JButton( "Calculate" );
        calcBtn.addActionListener( this );
        calcBtnPanel.add( calcBtn );
        bmiPanel.add( new JLabel( "BMI:" ) );
        bmiPanel.add( this.bmiField );
        messagePanel.add( this.messageField );
        frame.add( weightPanel );
        frame.add( heightPanel );
        frame.add( sexPanel );
        frame.add( calcBtnPanel );
        frame.add( bmiPanel );
        frame.add( messagePanel );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
    }
    @Override
    public void actionPerformed( ActionEvent e ) {
        try {
            int weight = Integer.parseInt( this.weightField.getText() );
            double height = Double.parseDouble( this.heightField.getText() );
            double bmi = weight / (height * height);
            this.bmiField.setText( Double.toString( bmi ) );
            this.messageField
                    .setText( this.getBMIType( this.rbMale.isSelected(), bmi ) );
        } catch ( Exception ex ) {
            this.bmiField.setText( "Bad input" );
        }
    }
    public String getBMIType( boolean male, double bmi ) {
        String erg;
        if ( male ) {
            if ( bmi < 20 ) {
                erg = "Short weight";
            } else if ( bmi < 25 ) {
                erg = "Normal weight";
            } else if ( bmi < 30 ) {
                erg = "Overweight";
            } else if ( bmi < 40 ) {
                erg = "Adiposity";
            } else {
                erg = "Massive Adiposity";
            }
        } else {
            if ( bmi < 19 ) {
                erg = "Short weight";
            } else if ( bmi < 24 ) {
                erg = "Normal weight";
            } else if ( bmi < 30 ) {
                erg = "Overweight";
            } else if ( bmi < 40 ) {
                erg = "Adiposity";
            } else {
                erg = "Massive Adiposity";
            }
        }
        return erg;
    }
    public static void main( String[] args ) {
        new BMICalculator();
    }
}