package de.dhbw.java.solution.operators;

import java.util.Scanner;
/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class Easter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ostertermin fuer welches Jahr berechnen? ");
        int year = scan.nextInt();
        scan.close();
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8 * k + 13) / 25;
        int q = k / 4;
        int M = (15 + k - p - q) % 30;
        int N = (4 + k - q) % 7;
        int d = (19 * a + M) % 30;
        int e = (2 * b + 4 * c + 6 * d + N) % 7;
        int easter = (22 + d + e);
        System.out.println("Im Jahr " + year +
                " ist der Ostersonntag am "+
                (easter<32 ? easter : easter-31) + ". " +
                (easter<32 ? "März" : "April"));
    }
}
