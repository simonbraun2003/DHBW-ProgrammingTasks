package de.dhbw.java.exercise.control;

import java.sql.SQLOutput;
import java.util.Scanner;

public class AddUp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        int sum = 0;
        while (input>=0) {
            sum += input;
            System.out.print("Zahl eingeben (<0 für Abbruch): ");
            input = scan.nextInt();
        };
        System.out.println("Summe: "+sum);
        scan.close();
    }
    /**
     * alternative implementation with do-while
     */
    public static void mainAlternative(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = 0;
        int sum = 0;
        do {
            sum += input;
            System.out.print("Zahl eingeben (<0 für Abbruch): ");
            input = scan.nextInt();
        } while (input >= 0);
        System.out.println("Summe: "+sum);
        scan.close();
    }
}
