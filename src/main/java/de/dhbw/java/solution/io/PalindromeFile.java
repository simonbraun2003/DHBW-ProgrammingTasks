package de.dhbw.java.solution.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016 by J. Sidler, T. Schlachter, C. Schmitt, W. Suess
 */
public class PalindromeFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Wort eingeben: ");
        String word = scan.next();
        StringBuilder reverse = new StringBuilder(word).reverse(); // RTFM!
        System.out.println("Umgekehrt: " + reverse);
        boolean isPalindrome = word.equalsIgnoreCase(reverse.toString());
        System.out.println(word + " ist "
                + (isPalindrome ? "" : "k")
                + "ein Palindrom.");
        scan.close();
        File palFile = new File("palindromes.txt");
// if palindrome: write it to palindrome file
        if (isPalindrome) {
            try (PrintWriter pw = new PrintWriter(
                    new FileWriter(palFile,true))) // true for "append"
            {
                pw.println(word);
            } catch (IOException e) {
                System.err.println("Fehler beim Schreiben: " +
                        e.getMessage());
            }
        }
        // Read all palindromes
        if (palFile.exists()) {
            System.out.println("Alle bisher gefundenen Palindrome:");
            try (BufferedReader br = new BufferedReader(
                    new FileReader(palFile)))
            {
                while (br.ready())
                    System.out.println(br.readLine());
            } catch (IOException e) {
                System.err.println("Fehler beim Lesen: " +
                        e.getMessage());
            }
        }
    }
}
