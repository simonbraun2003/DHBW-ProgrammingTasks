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
public class Fibonacci {
    /** Returns the value of the nth fibonacci number
     * @param n
     * @return value of the nth fibonacci number */
    private static int getFib(int n) {
        if (n<=2)
            return 1;
        return getFib(n-1) + getFib(n-2);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("n-te Fibonacci-Zahl bestimmen für n: ");
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.println("F(" + i + ") =" + getFib(i));
        }
        scan.close();
    }
}