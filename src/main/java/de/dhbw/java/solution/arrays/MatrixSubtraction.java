package de.dhbw.java.solution.arrays;

import java.util.Random;
import java.util.Scanner;
/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class MatrixSubtraction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();
        System.out.print("Bitte Anzahl der Zeilen n eingeben: ");
        int n = scan.nextInt();
        System.out.print("Bitte Anzahl der Spalten m eingeben: ");
        int m = scan.nextInt();
        int[][] x = new int [n][m];
        int[][] y = new int [n][m];
// fill arrays with random numbers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[i][j] = rnd.nextInt(100);
                y[i][j] = rnd.nextInt(100);
            }
        }
// output matrix x
        System.out.println("X:");
        for (int i = 0; i < n; i++) {
            for (int res : x[i]) {
                System.out.printf("%4d",res);
            }
            System.out.println();
        }
// output matrix y
        System.out.println("Y:");
        for (int i = 0; i < n; i++) {
            for (int res : y[i]) {
                System.out.printf("%4d",res);
            }
            System.out.println();
        }
// output result x-y
        System.out.println("X-Y:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%4d",x[i][j] - y[i][j]);
            }
            System.out.println();
        }
        scan.close();
    }
}