package de.dhbw.java.solution.ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
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
public class CurrencyCalculator {
    public final static float CHANGE_RATE = 1.14f;
    private JFrame frame = new JFrame( "Currency converter" );
    private JTextField input =
            new JTextField( "Please enter amount to convert!" );
    private JButton btnEur2usd = new JButton( "EUR -> USD" );
    private JButton btnUsd2eur = new JButton( "USD -> EUR" );
    private JButton btnCancel = new JButton( "Cancel" );
    public CurrencyCalculator() {
// default BorderLayout has no margin!
        this.frame.setLayout( new BorderLayout( 10, 10 ) );
        this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.frame.add( this.input, BorderLayout.NORTH );
        this.frame.add( this.btnEur2usd, BorderLayout.WEST );
        this.frame.add( this.btnUsd2eur, BorderLayout.CENTER );
        this.frame.add( this.btnCancel, BorderLayout.EAST );
        this.frame.setSize( 350, 100 );
        this.frame.setVisible( true );
    }
    public static void main( String[] args ) {
        new CurrencyCalculator();
    }
}