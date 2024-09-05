package de.dhbw.java.exercise.strings;

import java.util.Scanner;

public class CrossTotal {
    public static void main(String[] args) {
        int cross_total = 0;

        //Einlesen der Zahl
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        String input = sc.nextLine();
        sc.close();

        //Quersumme berechnen
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            cross_total += Integer.parseInt(String.valueOf(c));
        }
        System.out.println("Die Quersumme von " +input+ " ist: " + cross_total);
    }
}
