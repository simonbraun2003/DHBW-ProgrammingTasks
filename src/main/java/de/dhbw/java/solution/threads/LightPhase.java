package de.dhbw.java.solution.threads;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class LightPhase {
    private String name;
    private boolean red;
    private boolean yellow;
    private boolean green;
    private int duration;
    private LightPhase next;
    public LightPhase( String name, boolean red, boolean yellow, boolean green,
                       int duration, LightPhase next ) {
        this.name = name;
        this.red = red;
        this.yellow = yellow;
        this.green = green;
        this.duration = duration;
        this.next = next;
    }
    public LightPhase( String name, boolean red, boolean yellow, boolean green,
                       int duration ) {
        this( name, red, yellow, green, duration, null );
    }
    public String getName() {
        return this.name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public boolean isRed() {
        return this.red;
    }
    public void setRed( boolean red ) {
        this.red = red;
    }
    public boolean isYellow() {
        return this.yellow;
    }
    public void setYellow( boolean yellow ) {
        this.yellow = yellow;
    }
    public boolean isGreen() {
        return this.green;
    }
    public void setGreen( boolean green ) {
        this.green = green;
    }
    public int getDuration() {
        return this.duration;
    }
    public void setDuration( int duration ) {
        this.duration = duration;
    }
    public LightPhase getNext() {
        return this.next;
    }
    public void setNext( LightPhase next ) {
        this.next = next;
    }
}
