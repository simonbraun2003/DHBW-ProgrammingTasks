package de.dhbw.java.solution.arrays;

import java.util.Scanner;
/**
 * @author DHBW lecturer
 * @version 1.01
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015-2016 by W. Geiger, T. Schlachter, C. Schmitt, W. Süß
 */
public class Norm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = scan.nextInt();
        int[] x = new int[n];
        int norm = 0;
        for (int i = 0; i < x.length; i++) {
            System.out.print("Bitte x_" + i + " eingeben: ");
            x[i] = scan.nextInt();
        }
// this loop could be integrated with the preceding one
        for (int i = 0; i < x.length; i++)
            norm += x[i] * x[i];
        System.out.println("Der Betrag von x ist " + Math.sqrt(norm));
        scan.close();
    }
}
