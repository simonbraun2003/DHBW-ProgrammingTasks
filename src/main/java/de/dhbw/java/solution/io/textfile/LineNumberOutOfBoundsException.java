package de.dhbw.java.solution.io.textfile;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016 by J. Sidler, T. Schlachter, C. Schmitt, W. Suess
 */
@SuppressWarnings("serial")
public class LineNumberOutOfBoundsException extends Exception {
    public LineNumberOutOfBoundsException() {
        super();
    }
    public LineNumberOutOfBoundsException(String message) {
        super(message);
    }
}
