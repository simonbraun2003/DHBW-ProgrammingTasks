package de.dhbw.java.solution.ui.event;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CurrencyCalculator implements ActionListener {
    public final static float CHANGE_RATE = 1.09f;
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
// Add ActionListener to buttons (2nd part)
        this.btnEur2usd.addActionListener( this );
        this.btnUsd2eur.addActionListener( this );
        this.btnCancel.addActionListener( this );
        this.frame.setSize( 350, 90 );
        this.frame.setVisible( true );
    }
    /**
     * Event handling (2nd part)
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
        if ( e.getSource() == this.btnCancel ) {
            System.exit( 0 );
        }
        try {
            float amount = Float.parseFloat( this.input.getText() );
            if ( e.getSource() == this.btnEur2usd ) {
                amount = amount * CurrencyCalculator.CHANGE_RATE;
            }
            if ( e.getSource() == this.btnUsd2eur ) {
                amount = amount / CurrencyCalculator.CHANGE_RATE;
            }
            this.input.setText( Float.toString( amount ) );
        } catch ( Exception ex ) {
            this.input.setText( "Error parsing amount." );
        }
    }
    public static void main( String[] args ) {
        new CurrencyCalculator();
    }
}
