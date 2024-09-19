package de.dhbw.java.solution.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2016 by J. Sidler, T. Schlachter, C. Schmitt, W. Suess
 */
public class CrossTotalFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        String number = scan.next();
        int total = 0;
        for (char c : number.toCharArray())
            total += (c-'0');
        System.out.println("Die Quersumme von " + number +
                " ist " + total);
        scan.close();
        try (PrintWriter pw = new PrintWriter(
                new FileWriter("crosstotals.txt",true))) // true for "append"
        {
            pw.println("Quersumme von " + number + " ist " + total);
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben: " +
                    e.getMessage());
        }
    }
}
