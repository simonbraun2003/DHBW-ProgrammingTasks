package de.dhbw.java.solution.ui.event;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
@SuppressWarnings( "serial" )
public class ShellGame extends JFrame {
    private final static int LIMIT = 3; // Number of Buttons
    private final static String STATS_FILENAME = "shellstats.txt";
    private final Random rnd = new Random();
    private int shell;
    private int attempts = 0;
    private JButton[] shellButtons;
    private JButton btnExit = new JButton( "Exit" );
    private JButton btnStat = new JButton( "Statistics" );
    private JTextField txtName = new JTextField( "Name", 20 );
    private JTextField txtOutput = new JTextField( 30 );
    /**
     * Create shell game
     */
    public ShellGame() {
        super( "Shell Game" );
        this.setLayout( new GridLayout( 4, 1 ) );
        JPanel panName = new JPanel();
        JPanel panShell = new JPanel();
        JPanel panFunction = new JPanel();
        JPanel panOutput = new JPanel();
        panName.add( new JLabel( "Player Name" ) );
        panName.add( this.txtName );
        this.shellButtons = new JButton[ShellGame.LIMIT];
        for ( int i = 0; i < ShellGame.LIMIT; i++ ) {
            JButton btnShell = new JButton( "Shell " + (i + 1) );
            btnShell.setActionCommand( Integer.toString( i + 1 ) );
            this.shellButtons[i] = btnShell;
            panShell.add( btnShell );
        }
        panOutput.add( this.btnStat );
        panOutput.add( this.btnExit );
        panFunction.add( this.txtOutput );
        this.add( panName );
        this.add( panShell );
        this.add( panOutput );
        this.add( panFunction );
        this.initEventHandling();
        this.shell = this.getRandomShell();
        this.setSize( 400, 300 );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );
    }
    /**
     * Add event handling to buttons
     */
    public void initEventHandling() {
// Statistics
        this.btnStat.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent event ) {
                ShellGame.this.showStats();
            }
        } );
        // Exit
        this.btnExit.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent event ) {
                System.exit( 0 );
            }
        } );
// Shell-Listener for all Shell Buttons
        ActionListener shellListener = new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent event ) {
// Get Shell Number by ActionCommand
                ShellGame.this
                        .revealShell( Integer.parseInt( event.getActionCommand() ) );
            }
        };
        for ( JButton b : this.shellButtons ) {
            b.addActionListener( shellListener );
        }
    }
    /**
     * Reveal a shell
     */
    public void revealShell( int tip ) {
        this.attempts++;
        if ( tip == this.shell ) {
            this.txtOutput.setText( "Attempt " + this.attempts
                    + " wins: Ball was below shell " + this.shell );
            this.saveStats();
            this.attempts = 0;
        } else {
            this.txtOutput.setText( "Attempt " + this.attempts
                    + " fails: Ball was below shell " + this.shell );
        }
        this.shell = this.getRandomShell();
    }
    /**
     * Show statistics from stats file
     */
    private void showStats() {
        try ( BufferedReader in =
                      new BufferedReader( new FileReader( ShellGame.STATS_FILENAME ) ) ) {
            int count = 0;
            float sum = 0;
            while ( in.ready() ) {
                try {
                    sum += Integer.parseInt( in.readLine().split( ";" )[1] );
                    count++;
                } catch ( Exception e ) {
                }
            }
            this.txtOutput.setText( "Success after " + sum / count + " attempts!" );
        } catch ( IOException eee ) {
        }
    }
    /**
     * Add statistics to stats file
     */
    private void saveStats() {
        try ( PrintWriter f = new PrintWriter(
                new FileWriter( ShellGame.STATS_FILENAME, true ) ) ) {
            f.println( this.txtName.getText() + ";" + this.attempts );
        } catch ( IOException e ) {
        }
    }
    /**
     * Gets a random number for shell from 1..LIMIT
     */
    private int getRandomShell() {
        return this.rnd.nextInt( ShellGame.LIMIT ) + 1;
    }
    public static void main( String args[] ) {
        new ShellGame();
    }
}