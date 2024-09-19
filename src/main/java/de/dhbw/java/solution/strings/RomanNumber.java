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
public class RomanNumber {
    /** Get the decimal value of a Roman digit.
     * 0 is returned for invalid chars.
     * @param c Roman digit (char)
     * @return decimal value of a single Roman digit */
    private static int getValue(char c) {
        switch (Character.toUpperCase(c)) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }
    /** Get the decimal value of a Roman number.
     * The syntax is not checked.
     * @param c Roman number (String)
     * @return decimal value of the Roman number */
    public static int getValue(String s) {
        int result = 0;
// Add all numbers but the last
        for(int i=0; i<s.length()-1; i++) {
            int valueAti = getValue(s.charAt(i));
            result += (valueAti < getValue(s.charAt(i+1)))
                    ? -valueAti : valueAti;
        }
// Add last number
        result += getValue(s.charAt(s.length()-1));
        return result;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Bitte geben Sie eine röm. Zahl ein: ");
        String rome = scan.nextLine();
        System.out.println("Der Wert der Zahl " + rome + " ist "
                + getValue(rome));
        scan.close();
    }
}