package de.dhbw.java.solution.enums.cards;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.0
 */
public enum Suit {
    DIAMONDS("Karo", 9),
    HEART("Herz", 10),
    SPADE("Pik", 11),
    CLUBS("Kreuz", 12);
    private final String name;
    private final int value;
    private Suit( String name, int value ) {
        this.name = name;
        this.value = value;
    }
    @Override
    public String toString() {
        return this.name;
    }
    public String getName() {
        return this.name;
    }
    public int getValue() {
        return this.value;
    }
}