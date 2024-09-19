package de.dhbw.java.solution.collections;

import java.util.Random;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * Thanks to Steven Kovcs for the idea!
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class BinaryTreeTest {
    public static void main( String[] args ) {
        Random rnd = new Random();
        BinaryTree<Integer> tree = new BinaryTree<>();
        for ( int i = 0; i < 10; i++ ) {
            Integer newInt = rnd.nextInt( 20 );
            System.out.print( newInt );
            System.out.println( " " + tree.add( newInt ) );
        }
        System.out.println( "------------" );
        for ( Integer t : tree.traverse() ) {
            System.out.println( t.toString() );
        }
    }
}
