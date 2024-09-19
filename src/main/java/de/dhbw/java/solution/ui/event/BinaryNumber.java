package de.dhbw.java.solution.ui.event;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.0
 */
@SuppressWarnings( "serial" )
public class BinaryNumber extends JFrame implements ActionListener {
    /**
     * Label to display value
     */
    private JLabel lblValue = new JLabel( "0", JLabel.CENTER );
    /**
     * Current value
     */
    private int value = 0;
    /**
     * Create the binary number and init UI
     */
    public BinaryNumber() {
        super( "Binary Number" );
        this.setLayout( new BorderLayout( 5, 5 ) );
        this.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        final int countBits = 8;
        JPanel panSwitches = new JPanel( new GridLayout( 2, countBits, 5, 5 ) );
        ImageIcon imgOff = new ImageIcon( "off.png" );
        ImageIcon imgOn = new ImageIcon( "on.png" );
        // 1st row: buttons
        for ( int i = countBits - 1; i >= 0; i-- ) {
            JToggleButton btn = new JToggleButton();
            int num = (int) Math.pow( 2, i ); // calculate value for JToggleButton
            btn.setName( Integer.toString( num ) ); // and set value as name
            btn.setIcon( imgOff ); // icon if not selected
            btn.setSelectedIcon( imgOn ); // icon if selected
            btn.addActionListener( this );
            panSwitches.add( btn );
        }
// 2nd row: labels
        for ( int i = countBits - 1; i >= 0; i-- ) {
            panSwitches.add( new JLabel( "2^" + i, SwingConstants.CENTER ) );
        }
// enlarge font for value label
        this.lblValue.setFont( this.lblValue.getFont().deriveFont( 24f ) );
// add to JFrame
        this.add( panSwitches, BorderLayout.CENTER );
        this.add( this.lblValue, BorderLayout.SOUTH );
// Adapt size to content
        this.pack();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed( ActionEvent e ) {
// get the source of the event, must be a JToggleButton
        JToggleButton src = ((JToggleButton) e.getSource());
// parse the name as number
        int num = Integer.parseInt( src.getName() );
// and add or subtract depending on selected state
        if ( src.isSelected() ) {
            this.value += num;
        } else {
            this.value -= num;
        }
// update label
        this.lblValue.setText( Integer.toString( this.value ) );
    }
    /**
     * Application entry point
     *
     * @param args command line arguments
     */
    public static void main( String[] args ) {
        BinaryNumber bin = new BinaryNumber();
        bin.setVisible( true );
    }
}