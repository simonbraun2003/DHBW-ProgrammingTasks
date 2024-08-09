package de.dhbw.java.exercise.control;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Which year do you want to check? ");
            int year = sc.nextInt();
            System.out.println("-------------------------------------");

            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.out.println("Leap Year");
            } else {
                System.out.println("Not a leap year");
            }
            System.out.println();
        }
    }
}
