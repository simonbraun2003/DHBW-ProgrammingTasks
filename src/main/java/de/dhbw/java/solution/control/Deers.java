package de.dhbw.java.solution.control;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class Deers {
    public static void main(String[] args) {
        int deers = 200;
        int iteration = 0;
        do {
            deers = (int) ((deers * 1.1) - 15);
            System.out.println(++iteration + ": " + deers + " Hirsche");
        } while (deers < 300);
    }
}
