package de.dhbw.java.solution.ui.paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
@SuppressWarnings( "serial" )
public class ElectionSeats extends JComponent {
    private final static int MARGIN_LEFT = 10;
    private final static int MARGIN_TOP = 50;
    private final static Color TOP_COL = new Color( 0, 71, 129 );
    private final static Color BG_COL = new Color( 121, 170, 211 );
    private final static Color RULER_COL = new Color( 62, 133, 192 );
    private final static Font FONT =
            new Font( Font.SANS_SERIF, Font.BOLD, 16 );
    // filtered party list (only with seats!)
    private List<Party> parties;
    private String title;
    private int totalSeats;
    public ElectionSeats( String electionName, Party[] parties ) {
        this.title = electionName;
        this.parties = new ArrayList<>();
// calculate total count of seats
        for ( Party p : parties ) {
            this.totalSeats += p.getSeats();
// and add party only if it has seats!
            if ( p.getSeats() > 0 ) {
                this.parties.add( p );
            }
        }
    }
    public static void main( String[] args ) {
        JFrame frame = new JFrame( "Wahl" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 1280, 480 );
        frame.setLayout( new GridLayout( 1, 2 ) );
// use additional constructor with seat count
        Party[] parties = new Party[] {
                new Party( 33.0f, "Union", Color.BLACK, 246 ),
                new Party( 20.5f, "SPD", Color.RED, 153 ),
                new Party( 12.6f, "AfD", Color.BLUE, 94 ),
                new Party( 10.7f, "FDP", Color.YELLOW, 80 ),
                new Party( 9.2f, "Linke", Color.MAGENTA, 69 ),
                new Party( 8.9f, "Gr\u00FCne", Color.GREEN, 67 ),
                new Party( 5.1f, "Andere", Color.DARK_GRAY, 0 )
        };
// show election and seat view side by side
        Election election = new Election( "Bundestagswahl 2017", parties );
        ElectionSeats seats = new ElectionSeats( "Sitzverteilung", parties );
        frame.add( election );
        frame.add( seats );
        frame.setVisible( true );
    }
    @Override
    public void paintComponent( Graphics g ) {
// For a better understanding the drawing is divided in multiple sub-parts
// => some values are calculated multiple times and should be shared
// across the methods in a non-demo environment
        this.drawBackground( g );
        this.drawPieChart( g );
        this.drawPartyInfo( g );
    }
    private void drawBackground( Graphics g ) {
        final int width = this.getWidth();
        final int height = this.getHeight();
// Max height of bar = 2/3 of component height
        int baselineDiagramY = height * 2 / 3 + ElectionSeats.MARGIN_TOP;
        g.setFont( ElectionSeats.FONT );
// Background
        g.setColor( ElectionSeats.BG_COL );
        g.fillRect( 0, 0, width, height );
// Top background bar to write title on
        g.setColor( ElectionSeats.TOP_COL );
        g.fillRect( 0, 0, width, 30 );
// set line/ruler color
        g.setColor( ElectionSeats.RULER_COL );
// line below top background bar
        g.fillRect( 0, 30, width, 2 );
// Thick line above bottom white bar
        g.fillRect( 0, baselineDiagramY, width, 10 );
// line below bottom white bar
        g.fillRect( 0, baselineDiagramY + 40, width, 2 );
// line below percentage of parties
        g.fillRect( 0, baselineDiagramY + 65, width, 2 );
        g.setColor( Color.WHITE );
        // Bottom white bar
        g.fillRect( 0, baselineDiagramY + 10, width, 30 );
// Top title on the left
        g.drawString( this.title.toUpperCase(), ElectionSeats.MARGIN_LEFT, 22 );
// Top info on the right
        g.drawString( Integer.toString( this.totalSeats ), width - 40, 22 );
    }
    private void drawPieChart( Graphics g ) {
// seats distribution is usually shown with a pie chart
// based on a semicircle
// ==> seats must be distributed on 180 degrees
// Important: avoid integer division!
        float degreePerSeat = 180f / this.totalSeats;
// width of circle, use 90% of component
        int cirleWidth = (int) (this.getWidth() * 0.9f);
// height of circle, use 100% of height to
// get 50% pie chart (remember: semicircle!)
        int circleHeight = this.getHeight();
// X value of circle is at 5% of width
// (90% circle with means 5% padding on each side)
        int cirlceX = (int) (this.getWidth() * 0.05f);
// circle y (same as baselineDiagramY from background)
        int circleY = this.getHeight() * 2 / 3 + ElectionSeats.MARGIN_TOP;
// current arc start angle, since we want to
// start on the left, its's 180°
        int arcStart = 180;
// let's draw the parties
        for ( Party party : this.parties ) {
// First: part of the pie chart
            int angle = Math.round( party.getSeats() * degreePerSeat );
            g.setColor( party.getColor() );
            g.fillArc( cirlceX, circleY - circleHeight / 2, cirleWidth,
                    circleHeight, arcStart - angle, angle );
            arcStart -= angle;
        }
    }
    private void drawPartyInfo( Graphics g ) {
        int width = this.getWidth();
        int height = this.getHeight();
        int count = this.parties.size();
        int gap = 20;
// Diagram y, see background
        int baseY = height * 2 / 3 + ElectionSeats.MARGIN_TOP;
        // party color rectangle with:
// total area to draw: 90% (like circle)
// minus all gaps (gap count: party count -1)
        int colorRectWidth = (int) ((width * 0.9f - (count - 1) * gap) / count);
// align start x to circle
        int partyInfoX = (int) (this.getWidth() * 0.05f);
// set font
        g.setFont( ElectionSeats.FONT );
        for ( Party party : this.parties ) {
            g.setColor( party.getColor() );
            g.fillRect( partyInfoX, baseY + 10, colorRectWidth, 10 );
            g.setColor( Color.BLACK );
// draw party name
            g.drawString( party.getName(), partyInfoX, baseY + 36 );
// draw seat count
            g.drawString( Integer.toString( party.getSeats() ), partyInfoX,
                    baseY + 60 );
// offset x by rectangle with + gap
            partyInfoX += colorRectWidth + gap;
        }
    }
}
