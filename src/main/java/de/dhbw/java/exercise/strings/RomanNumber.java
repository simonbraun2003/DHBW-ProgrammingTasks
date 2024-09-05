package de.dhbw.java.exercise.strings;

import java.util.Scanner;

public class RomanNumber { //ToDo: AUS DEN LÖSUNGEN KOPIERT!!
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
    public static int getValue(String s) {
        int result = 0;
        // Add all numbers but the last
        for (int i = 0; i < s.length() - 1; i++) {
            int valueAti = getValue(s.charAt(i));
            result += (valueAti < getValue(s.charAt(i + 1)))
                    ? -valueAti : valueAti;
        }
        // Add last number
        result += getValue(s.charAt(s.length() - 1));
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
