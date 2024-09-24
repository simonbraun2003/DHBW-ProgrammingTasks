package de.dhbw.java.solution.enums.cards;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public enum CardValue {
    SEVEN("7", "7"),
    EIGHT("8", "8"),
    NINE("9", "9"),
    JACK("B", "Bube"),
    QUEEN("D", "Dame"),
    KING("K", "K\u00F6nig"),
    TEN("10", "10"),
    ACE("A", "Ass");
    private final String name;
    private final String longName;
    private CardValue( String name, String longName ) {
        this.name = name;
        this.longName = longName;
    }
    @Override
    public String toString() {
        return this.longName;
    }
    public String getName() {
        return this.name;
    }
    public String getLongName() {
        return this.longName;
    }
}
