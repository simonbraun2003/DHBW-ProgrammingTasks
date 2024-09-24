package de.dhbw.java.solution.enums.library;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public enum Attributes {
    TITLE("Title"),
    AUTHOR("Author"),
    YEAR("Year"),
    PUBLISHER("Publisher");
    private String name;
    private Attributes( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}