package de.dhbw.java.solution.enums.library;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class Library {
    private JFrame frame;
    private String filename = "books.txt";
    private List<JTextField> inputFields;
    private List<Book> books = new ArrayList<>();
    public Library() {
        this.loadBooks();
// Input fields incl. labels
        JPanel panInput = new JPanel();
        panInput.setLayout( new GridLayout( 4, 2, 5, 5 ) );
        this.inputFields = new ArrayList<>();
        for ( Attributes att : Attributes.values() ) {
            JTextField field = new JTextField( "" );
            this.inputFields.add( field );
            panInput.add( new JLabel( att.getName() ) );
            panInput.add( field );
        }
        // save button incl. event handling
        JButton btnSave = new JButton( "Save entry" );
        btnSave.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent e ) {
                Library.this.saveBook( Library.this.inputFields.get( 0 ).getText(),
                        Library.this.inputFields.get( 1 ).getText(),
                        new Integer( Library.this.inputFields.get( 2 ).getText() ),
                        Library.this.inputFields.get( 3 ).getText() );
// Reset fields
                for ( JTextField field : Library.this.inputFields ) {
                    field.setText( "" );
                }
            }
        } );
// sort buttons incl. event handling
        JPanel panSort = new JPanel( new FlowLayout() );
        panSort.add( new JLabel( "Ordered output:" ) );
        for ( Attributes att : Attributes.values() ) {
            JButton but = new JButton( att.getName() );
            but.setActionCommand( att.toString() ); // artificial attribute
            but.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed( ActionEvent e ) {
                    Library.this.sort( Attributes
                            .valueOf( ((JButton) e.getSource()).getActionCommand() ) );
                }
            } );
            panSort.add( but );
        }
        this.frame = new JFrame( "Library" );
        this.frame.setLayout( new BorderLayout() );
        this.frame.add( panInput, BorderLayout.NORTH );
        this.frame.add( btnSave, BorderLayout.CENTER );
        this.frame.add( panSort, BorderLayout.SOUTH );
        this.frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.frame.setSize( 500, 190 );
        this.frame.setVisible( true );
    }
    public void saveBook( String title, String author, int year,
                          String publisher ) {
        Book book = new Book( title, author, year, publisher );
        this.books.add( book );
        try ( PrintWriter pw = new PrintWriter(
                new FileWriter( new File( this.filename ), true ) ); ) {
            pw.println( book ); // uses toString of Book
        } catch ( Exception ex ) {
            System.err
                    .println( "Write error: " + ex.getLocalizedMessage() );
        }
    }
    public void loadBooks() {
        try ( BufferedReader br = new BufferedReader(
                new FileReader( new File( this.filename ) ) ); ) {
            while ( br.ready() ) {
                String[] parts = br.readLine().split( ";" );
                if ( parts.length == 4 ) {
                    this.books.add( new Book( parts[0], parts[1],
                            new Integer( parts[2] ), parts[3] ) );
                }
            }
        } catch ( Exception ex ) {
            System.err.println( "Read error: " + ex.getLocalizedMessage() );
        }
    }
    /**
     * Order books by order criteria and display ordered list
     */
    public void sort( Attributes order ) {
        Collections.sort( this.books, new BookComparator( order ) );
// uses Library.toString()
        JOptionPane.showMessageDialog( this.frame, this,
                "Books ordered by " + order.getName(),
                JOptionPane.INFORMATION_MESSAGE );
    }
    /**
     * All books as a single multi line String
     *
     * @return string with one book per line
     */
    @Override
    public String toString() {
        StringBuffer output = new StringBuffer( "" );
        for ( Book book : this.books ) {
            output.append( book + System.lineSeparator() );
        }
        return output.toString();
    };
    public static void main( String[] args ) {
        new Library();
    }
}