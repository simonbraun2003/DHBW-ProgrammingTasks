package de.dhbw.java.solution.ui;

import java.awt.FlowLayout;
import javax.swing.*;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
@SuppressWarnings( "serial" )
public class ComponentFrame extends JFrame {
    public ComponentFrame() {
        this( "ComponentFrame" );
    }
    @SuppressWarnings( { "unchecked", "rawtypes" } )
    public ComponentFrame( String title ) {
        super( title );
// Default layout for JFrame content would be BorderLayout!
        this.setLayout( new FlowLayout() );
        this.add( new JLabel( "JLabel" ) );
        this.add( new JTextField( "JTextField" ) );
        this.add( new JPasswordField( "JPasswordField" ) );
        this.add( new JButton( "JButton" ) );
        this.add( new JToggleButton( "JToggleButton" ) );
        this.add( new JCheckBox( "JCheckBox" ) );
// No generic type for JComboBox - we had no generics yet
        this.add( new JComboBox(
                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" } ) );
// ButtonGroup connects the RadioButtons as a functional unit
        ButtonGroup group = new ButtonGroup();
        for ( int i = 1; i <= 3; i++ ) {
            JRadioButton rb = new JRadioButton( "Radio-Button-" + i );
            group.add( rb );
            this.add( rb );
        }
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize( 640, 100 );
        this.setVisible( true );
    }
    public static void main( String[] args ) {
        new ComponentFrame( "Several basic Swing components" );
    }
}
