package de.dhbw.java.solution.ui.paint;

import java.awt.Color;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.3
 */
public class Party {
    private float percentage;
    private String name;
    private Color color;
    // Extension for seats
    private int seats;
    public Party( float percentage, String name, Color color ) {
        this.percentage = percentage;
        this.name = name;
        this.color = color;
    }
    // Extension for seats
    public Party( float percentage, String name, Color color, int seats ) {
        this( percentage, name, color );
        this.seats = seats;
    }
    public float getPercentage() {
        return this.percentage;
    }
    public String getName() {
        return this.name;
    }
    public Color getColor() {
        return this.color;
    }
    // Extension for seats
    public int getSeats() {
        return this.seats;
    }
}
