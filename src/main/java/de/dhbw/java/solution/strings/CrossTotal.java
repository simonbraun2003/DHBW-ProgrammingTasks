package de.dhbw.java.solution.strings;

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
public class CrossTotal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        String number = scan.next();
        int total = 0;
        for(int i=0; i<number.length(); i++)
            total += number.charAt(i) - '0';
// Alternative Implementierung
// for (char c : number.toCharArray())
// total += (c - '0');
        System.out.println("Die Quersumme von " + number +
                " ist " + total);
        scan.close();
    }
}