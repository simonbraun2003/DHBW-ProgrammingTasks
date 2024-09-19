package de.dhbw.java.solution.ui;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class TextfileViewer {
    private static final int MAX_LINES = 10;
    public TextfileViewer( File file ) {
        JFrame frame = new JFrame( file.getName() );
        String[] content = TextfileViewer.readTextfile( file );
        final int displayLines =
                Math.min( content.length, TextfileViewer.MAX_LINES );
        frame.setLayout( new GridLayout( displayLines, 1 ) );
        for ( int i = 0; i < displayLines; i++ ) {
            frame.add( new JLabel( content[i] ) );
        }
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 640, 480 );
        frame.setVisible( true );
    }
    /**
     * Read text file and return its content as an string array
     *
     * @param f
     * text file
     * @return content as string array
     */
    public static String[] readTextfile( File f ) {
// Count lines first (remember: arrays => fix length!)
        int lines = 0;
        try ( BufferedReader br = new BufferedReader( new FileReader( f ) ) ) {
            while ( br.ready() ) {
                br.readLine();
                lines++;
            }
        } catch ( IOException e ) {
            e.printStackTrace(); // TODO: nice error handling
        }
// Create array with count of lines as length
        String[] result = new String[lines];
        lines = 0;
        try ( BufferedReader br = new BufferedReader( new FileReader( f ) ) ) {
            while ( br.ready() ) {
                result[lines++] = br.readLine();
            }
        } catch ( IOException e ) {
            e.printStackTrace(); // TODO: nice error handling
        }
        return result;
    }
    public static void main( String[] args ) {
// FileChooser as presented in slides "Swing"
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter( new FileFilter() {
            @Override
            public boolean accept( File f ) {
                return f.isDirectory()
                        || f.getName().toLowerCase().endsWith( ".txt" );
            }
            @Override
            public String getDescription() {
                return "Text files (*.txt)";
            }
        } );
        int state = fc.showOpenDialog( null );
        if ( state == JFileChooser.APPROVE_OPTION ) {
            new TextfileViewer( fc.getSelectedFile() );
        } else {
            JOptionPane.showMessageDialog( null, "Choice cancelled" );
        }
    }
}
//Version-2
/*
import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
/**
* Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
* Cooperative State University.
*
* (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
*
* @author DHBW lecturer
* @version 1.1
public class TextfileViewer2 {
    public TextfileViewer2( File file ) {
        JFrame frame = new JFrame( file.getName() );
        StringBuilder joinedContent = new StringBuilder();
        for ( String s : TextfileViewer.readTextfile( file ) ) {
            joinedContent.append( s ).append( System.lineSeparator() );
        }
        JScrollPane scrollpane =
                new JScrollPane( new JTextArea( joinedContent.toString() ) );
// remember: default layout for frame content border layout
        frame.add( scrollpane, BorderLayout.CENTER );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 640, 480 );
        frame.setVisible( true );
    }
    public static void main( String[] args ) {
// FileChooser as presented in slides "Swing"
JFileChooser fc = new JFileChooser();
fc.setFileFilter( new FileFilter() {
@Override
public boolean accept( File f ) {
return f.isDirectory()
|| f.getName().toLowerCase().endsWith( ".txt" );
}
@Override
public String getDescription() {
return "Text files (*.txt)";
}
} );
int state = fc.showOpenDialog( null );
if ( state == JFileChooser.APPROVE_OPTION ) {
new TextfileViewer2( fc.getSelectedFile() );
} else {
JOptionPane.showMessageDialog( null, "Choice cancelled" );
}
}
}
 */