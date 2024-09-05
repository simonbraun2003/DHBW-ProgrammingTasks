package de.dhbw.java.exercise.strings;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String palindrome= "";

        //Einlesen des Wortes
        System.out.print("Bitte Wort eingeben: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        //Umdrehen des Wortes
        for (int i = input.length(); i > 0; i--) {
            palindrome += input.charAt(i - 1);
        }
        System.out.println("Umgekehrt: " + palindrome);

        //Vergleich auf Palindrome
        if(input.equalsIgnoreCase(palindrome)){
            System.out.println(input + " ist ein Palindrome");
        }

    }
}
