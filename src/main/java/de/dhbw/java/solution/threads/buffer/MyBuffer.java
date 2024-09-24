package de.dhbw.java.solution.threads.buffer;

import java.util.LinkedList;
import java.util.List;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class MyBuffer {
    private final static int MAXSIZE = 3;
    private List<Integer> values = new LinkedList<>();
    /**
     * The producer routine
     *
     * @param value
     * value to put in buffer
     */
    public synchronized void put( int value ) {
        if ( !(this.values.size() < MyBuffer.MAXSIZE) ) {
            System.out.println( "Buffer full - wait!" );
            try {
                this.wait();
            } catch ( InterruptedException e ) {
            }
        } // buffer is empty, fill it!
        this.values.add( new Integer( value ) );
// notify waiting consumer via notify()
        this.notify();
        System.out.println( "Put: " + value );
    }
    /**
     * The consumer routine
     *
     * @return value from buffer
     */
    public synchronized int get() {
// consumer must wait until buffer is not empty
        if ( this.values.size() == 0 ) {
            try {
                System.out.println( "Buffer empty - wait!" );
                this.wait();
            } catch ( InterruptedException e ) {
            }
        }
// buffer has at least one Element, remove it!
        int value = this.values.remove( 0 );
// notify waiting producer via notify()
        this.notify();
        System.out.println( "Get: " + value );
        return value;
    }
}
