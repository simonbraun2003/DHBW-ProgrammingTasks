package de.dhbw.java.solution.control;

import java.util.Scanner;
/**
 * @author DHBW lecturer
 * @version 1.01
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Suess
 */
public class LeapYear {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Welches Jahr auf Schaltjahr pruefen? ");
        int year = scan.nextInt();
        scan.close();
        boolean isLeapYear = false;
        if (year % 400 == 0) {
            isLeapYear = true;
        } else if (year % 100 == 0) {
        } else if (year % 4 == 0) {
            isLeapYear = true;
        }
        System.out.println(year + " ist " +
                (isLeapYear ? "ein" : "kein") +
                " Schaltjahr");
    }
}