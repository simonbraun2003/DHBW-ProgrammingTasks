package de.dhbw.java.solution.ui.event;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
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
public class NumberGuess extends JFrame {
    private int numberToGuess;
    private int countAttempts;
    private int limit = 1000;
    private JButton btnExit = new JButton( "Exit" );
    private JButton btnOk = new JButton( "OK" );
    private JButton btnNew = new JButton( "New Game" );
    private JButton btnStat = new JButton( "Best Player" );
    private JTextField txtName = new JTextField( "Name", 20 );
    private JTextField txtGuess = new JTextField( 10 );
    private JTextField txtOutput = new JTextField( 40 );
    private String statFileName = "stat.txt";
    public NumberGuess() {
        super( "Number Guessing Game" );
        JPanel panName = new JPanel();
        JPanel panNumberinput = new JPanel();
        JPanel panButtons = new JPanel();
        JPanel panOutput = new JPanel();
        panName.add( new JLabel( "Player Name" ) );
        panName.add( this.txtName );
        panNumberinput.add(
                new JLabel( "Enter number beween 1 and " + this.limit ) );
        panNumberinput.add( this.txtGuess );
        panButtons.add( this.btnNew );
        panButtons.add( this.btnOk );
        panButtons.add( this.btnStat );
        panButtons.add( this.btnExit );
        panOutput.add( this.txtOutput );
        this.setLayout( new GridLayout( 4, 1 ) );
        this.add( panName );
        this.add( panNumberinput );
        this.add( panButtons );
        this.add( panOutput );
        this.addEventHandling();
        this.createRandomNumber();
        this.setSize( 500, 250 );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setVisible( true );
    }
    public void addEventHandling() {
        this.btnNew.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent event ) {
                NumberGuess.this.createRandomNumber();
            }
        } );
        this.btnExit.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent event ) {
                System.exit( 0 );
            }
        } );
        ActionListener okListener = new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent event ) {
                NumberGuess.this.okActionListener( event );
            }
        };
        this.txtGuess.addActionListener( okListener );
        this.btnOk.addActionListener( okListener );
        this.btnStat.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent event ) {
                NumberGuess.this.showBestPlayer();
            }
        } );
    }
    public void okActionListener( ActionEvent event ) {
        try {
            int guess = Integer.parseInt( this.txtGuess.getText() );
            this.countAttempts++;
            this.txtGuess.setText( "" );
            if ( guess > this.numberToGuess ) {
                this.txtOutput.setText( String.format(
                        "Attempt #%s: %s => too big!", this.countAttempts, guess ) );
            }
            else if ( guess < this.numberToGuess ) {
                this.txtOutput.setText( String.format(
                        "Attempt #%s: %s => too small!", this.countAttempts,
                        guess ) );
            }
            else {
                this.txtOutput.setText(
                        String.format( "Attempt #%s: %s => correct!!! New Game!",
                                this.countAttempts, guess ) );
                this.writeStatFile();
                this.createRandomNumber();
            }
        } catch ( NumberFormatException nfe ) {
            this.txtOutput.setText( "Bad input!" );
        }
    }
    private void writeStatFile() {
        try ( FileWriter f = new FileWriter( this.statFileName, true ) ) {
            String name = this.txtName.getText();
            f.write( name + " " + this.countAttempts + " attempts\n" );
        } catch ( Exception e ) {
        }
    }
    private void showBestPlayer() {
        int minAttempts = Integer.MAX_VALUE;
        String name = "";
        try ( BufferedReader in =
                      new BufferedReader( new FileReader( this.statFileName ) ) ) {
            String line;
            do {
                try {
                    line = in.readLine();
                    if ( line != null ) {
                        StringTokenizer st = new StringTokenizer( line );
                        String currLineName = st.nextToken();
                        try {
                            int currLinePoints = Integer.parseInt( st.nextToken() );
                            if ( currLinePoints < minAttempts ) {
                                name = currLineName;
                                minAttempts = currLinePoints;
                            }
                        } catch ( Exception e ) {
                        }
                    }
                } catch ( IOException e ) {
                    line = null;
                }
            } while ( line != null );
            this.txtOutput.setText( "Best Player: " + name + ", " + minAttempts
                    + " attempts" );
        } catch ( Exception ex ) {
        }
    }
    private void createRandomNumber() {
        this.txtGuess.setText( "" );
        this.txtOutput.setText( "New Game!" );
        this.numberToGuess = (int) (Math.random() * this.limit + 1);
        this.countAttempts = 0;
// For debugging purposes
        System.out.println( "Number to guess: " + this.numberToGuess );
    }
    public static void main( String args[] ) {
        new NumberGuess();
    }
}