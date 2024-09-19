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
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = scan.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < x.length; i++) {
            System.out.print("Zahl " + i + " eingeben: ");
            x[i] = scan.nextInt();
        }
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < x.length; i++) {
                if (x[i-1]>x[i]) {
                    int tmp = x[i-1];
                    x[i-1] = x[i];
                    x[i] = tmp;
                    swapped = true;
                }
            }
        } while (swapped);
        System.out.print("Sortiert: ");
        for (int i : x) {
            System.out.print(i + " ");
        }
        scan.close();
    }
}
