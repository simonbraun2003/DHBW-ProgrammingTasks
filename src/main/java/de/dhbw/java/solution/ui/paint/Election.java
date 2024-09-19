package de.dhbw.java.solution.ui.paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2021 by T. Schlachter, C. Schmitt, W. Suess, N. Doms
 *
 * @author DHBW lecturer
 * @version 1.3
 */
@SuppressWarnings( "serial" )
public class Election extends JComponent {
    private final static int MARGIN_LEFT = 10;
    private final static int MARGIN_RIGHT = 10;
    private final static int MARGIN_TOP = 50;
    private final static Color TOP_COL = new Color( 0, 71, 129 );
    private final static Color BG_COL = new Color( 121, 170, 211 );
    private final static Color RULER_COL = new Color( 62, 133, 192 );
    private final static Font FONT = new Font( Font.SANS_SERIF, Font.BOLD, 16 );
    private final static String INFO_TEXT = "in %";
    private final Party[] parties;
    private final String electionName;
    private double maxPercentageOfParties = 0.0f;
    public Election( String electionName, Party[] parties ) {
        this.electionName = electionName;
        this.parties = parties;
// find maximum percentage of all parties
        for ( Party p : parties ) {
            this.maxPercentageOfParties =
                    Math.max( p.getPercentage(), this.maxPercentageOfParties );
        }
    }
    @Override
    public void paintComponent( Graphics g ) {
        final int width = this.getWidth();
        final int height = this.getHeight();
        int maxBarWidth = (width - Election.MARGIN_LEFT - Election.MARGIN_RIGHT)
                / this.parties.length;
// Max height of bar = 2/3 of component height
        int totalBarHeight = height * 2 / 3;
// height for 1 percent point
        double heightPerPercent = totalBarHeight / this.maxPercentageOfParties;
// After calculating height for 1 percent, add margin top to total height
        totalBarHeight += Election.MARGIN_TOP;
        g.setFont( Election.FONT );
        g.setColor( Election.BG_COL ); // Background color
        g.fillRect( 0, 0, width, height ); // Background rectangle
// Top background bar to write title on
        g.setColor( Election.TOP_COL );
        g.fillRect( 0, 0, width, 30 );
        g.setColor( Election.RULER_COL ); // set line/ruler color
        g.fillRect( 0, 30, width, 2 ); // line below top background bar
// Thick line above bottom white bar
        g.fillRect( 0, totalBarHeight, width, 10 );
// line below bottom white bar
        g.fillRect( 0, totalBarHeight + 40, width, 2 );
// line below percentage of parties
        g.fillRect( 0, totalBarHeight + 65, width, 2 );
        g.setColor( Color.WHITE );
// Bottom white bar
        g.fillRect( 0, totalBarHeight + 10, width, 30 );
// Top title on the left
        g.drawString( this.electionName.toUpperCase(), Election.MARGIN_LEFT, 22 );
// Top info on the right
        g.drawString( Election.INFO_TEXT, width - 40, 22 );
// thin white helper lines (10% intervals)
        for ( int i = 1; i <= (int) (this.maxPercentageOfParties / 10); i++ ) {
            g.drawLine( 0, (int) (totalBarHeight - i * 10 * heightPerPercent),
                    width, (int) (totalBarHeight - i * 10 * heightPerPercent) );
        }
// draw parties with helper function
        for ( int i = 0; i < this.parties.length; i++ ) {
            int partyHeight =
                    (int) (this.parties[i].getPercentage() * heightPerPercent);
            this.drawBar( g, Election.MARGIN_LEFT + i * maxBarWidth,
                    totalBarHeight - partyHeight, maxBarWidth,
                    partyHeight, this.parties[i] );
        }
    }
    /**
     * Draw bar for party
     *
     * @param g
     * graphics
     * @param x
     * x (left) to draw from
     * @param y
     * y (top) to draw from
     * @param width
     * width of bar
     * @param height
     * height of bar
     * @param party
     * party
     */
    public void drawBar( Graphics g, int x, int y, int width, int height,
                         Party party ) {
        int margin = 10;
        int shadow = 2;
// draw shadow rectangle
        g.setColor( java.awt.Color.GRAY );
        g.fillRect( x + margin + shadow, y - shadow + 1, width - 2 * margin,
                height );
        g.setColor( party.getColor() ); // draw actual colored bar over shadow
// above line
        g.fillRect( x + margin, y, width - 2 * margin, height );
// below line
        g.fillRect( x + margin, y + height + 10, width - 2 * margin, 10 );
        g.setColor( java.awt.Color.BLACK );
// Draw name of party
        g.drawString( party.getName(), x + margin, y + height + 36 );
// Draw percentage value, but replace decimal '.' with ','
        g.drawString( Float.toString( party.getPercentage() ).replace( '.', ',' ),
                x + margin + 5, y + height + 60 );
    }
    public static void main( String[] args ) {
        JFrame frame = new JFrame( "Wahl" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 640, 480 );
        frame.add( new Election( "Bundestagswahl 2021", new Party[] {
                new Party( 25.7f, "SPD", Color.RED ),
                new Party( 24.1f, "Union", Color.BLACK ),
                new Party( 14.8f, "Gr\u00FCne", Color.GREEN ),
                new Party( 11.5f, "FDP", Color.YELLOW ),
                new Party( 10.3f, "AfD", Color.BLUE ),
                new Party( 4.9f, "Linke", Color.MAGENTA ),
                new Party( 0.1f, "SSW", new Color(0,73,167) ),
                new Party( 8.6f, "Andere", Color.DARK_GRAY )
        } ) );
        frame.setVisible( true );
    }
}