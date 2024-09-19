package de.dhbw.java.solution.strings;

import java.util.Scanner;
/**
 * @author DHBW lecturer
 * @version 1.1
 *
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2015-2024 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte Wort eingeben: ");
        String word = scan.nextLine();
        StringBuilder reverse = Palindrome.reverse(word);
// Alternativ
// StringBuilder reverse = new StringBuilder(word).reverse(); // RTFM!
        System.out.println("Umgekehrt: " + reverse);
        System.out.println(word + " ist "
                + (word.equalsIgnoreCase(reverse.toString()) ? "" : "k")
                + "ein Palindrom.");
        scan.close();
    }
    public static StringBuilder reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--)
            sb.append(s.charAt(i));
        return sb;
    }
}
