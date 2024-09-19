package de.dhbw.java.solution.arrays;

import java.util.Scanner;
/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by W. Geiger, T. Schlachter, C. Schmitt, W. Süß
 */
public class DotProduct {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = scan.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int dotProduct = 0;
        for (int i = 0; i < x.length; i++) {
            System.out.print("Bitte x_" + i + " eingeben: ");
            x[i] = scan.nextInt();
        }
        for (int i = 0; i < y.length; i++) {
            System.out.print("Bitte y_" + i + " eingeben: ");
            y[i] = scan.nextInt();
        }
// this loop could be integrated with the preceding one
        for (int i = 0; i < x.length; i++)
            dotProduct += x[i] * y[i];
        System.out.println("Das Skalarprodukt von x und y ist "
                +dotProduct);
        scan.close();
    }
}
