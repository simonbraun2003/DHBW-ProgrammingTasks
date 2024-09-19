package de.dhbw.java.solution.datatypes;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Suess
 */
public class ShortValue {
    public static void main(String[] args) {
        short val = 32767;
        System.out.println("val: "+val);
        val++;
        System.out.println("val+1: "+val);
    }
}