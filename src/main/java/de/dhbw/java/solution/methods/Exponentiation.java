package de.dhbw.java.solution.methods;

import java.util.Scanner;
/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Suess
 */
public class Exponentiation {
    public static double xPowerN(double x, int n) {
        if (n==0)
            return 1.0;
        return x * xPowerN(x, n-1);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Geben Sie bitte die Basis ein: ");
        double x = scan.nextDouble();
        System.out.print("Geben Sie bitte den positiven " +
                "ganzzahligen Exponenten ein: ");
        int n = scan.nextInt();
        System.out.println(x + "^ " + n + " = " + xPowerN(x,n));
    }
}