package de.dhbw.java.solution.operators;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class IncrementDecrement {
    public static void main(String[] args) {
        int i=0;
        int j=0;
        j = ++i;
        int k = j++ + ++i;
        System.out.println("k: " + k); //k: 3
        System.out.println("*: " + j++ + ++i); //*: 23
        System.out.println(j++ + ++i); //7
        int m = j++ * ++i;
        System.out.println("m: " + m); //m: 20
        int n = --j * --i;
        System.out.println("n: " + n); //n: 16
        System.out.println("i: " + i); //i: 4
        System.out.println("j: " + j); //J: 4
    }
}
