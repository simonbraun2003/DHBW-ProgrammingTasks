package de.dhbw.java.solution.ui;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
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
public class TextFrame extends JFrame {
    public TextFrame( String filename, int width, int height ) {
        super( filename );
        this.setLayout( new BorderLayout() );
        this.add( new JTextArea( TextFrame.readFile( filename ) ) );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        this.setSize( width, height );
        this.setVisible( true );
    }
    /**
     * Read a text file and return its content as String
     *
     * @param filename
     * file name to open text file from
     * @return content of file
     */
    private static String readFile( String filename ) {
        StringBuilder content = new StringBuilder();
        try ( BufferedReader br =
                      new BufferedReader( new FileReader( filename ) ) ) {
            while ( br.ready() ) {
                content.append( br.readLine() ).append( System.lineSeparator() );
            }
        } catch ( IOException e ) {
            return "Error reading File " + filename;
        }
        return content.toString();
    }
    public static void main( String[] args ) {
        try { // if argument count < 3 or non-parsable content => exception
            new TextFrame( args[0], Integer.parseInt( args[1] ),
                    Integer.parseInt( args[2] ) );
        } catch ( Exception e ) {
            System.out
                    .println( "Please use: TextFrame <filename> <width> <height>\n" +
                            "with an existing (relative or absolute) filename and\n" +
                            "integer values for width and height." );
        }
    }
}
