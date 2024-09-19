package de.dhbw.java.solution.collections;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class Lottery {
    public static void main( String[] args ) {
// Set => no duplicates
// TreeSet => ordered!
        Set<Integer> numbers = new TreeSet<>();
// store number that was added last
        Integer addNumber = null;
        Random r = new Random();
// Remember: usage of Set prevents duplicates
        while ( numbers.size() < 7 ) {
            numbers.add( addNumber = r.nextInt( 49 ) + 1 ); // Autoboxing
        }
// remove last added number => that's the bonus number!
        numbers.remove( addNumber );
        for ( Integer no : numbers ) {
            System.out.print( no + " " );
        }
        System.out.println( "Bonus number: " + addNumber );
    }
}