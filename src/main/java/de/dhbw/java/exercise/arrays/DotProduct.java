package de.dhbw.java.exercise.arrays;

import java.util.Scanner;

public class DotProduct {
    public static void main(String[] args) {
        double result = 0;
        double sum = 0;

        //Scanner zum einlesen der Werte
        Scanner sc = new Scanner(System.in);

        //Abfrage und initialisierung der Arraygröße
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = sc.nextInt();
        int[] vecX = new int[n];
        int[] vecY = new int[n];

        //Abfrage der Werte
        for (int i = 0; i < vecX.length; i++){
            System.out.print("Bitte x_" + i + " eingeben: ");
            vecX[i] = sc.nextInt();
        }
        for (int i = 0; i < vecY.length; i++){
            System.out.print("Bitte y_" + i + " eingeben: ");
            vecY[i] = sc.nextInt();
        }
        sc.close();

        //Berechnung des Betrages
        for (int i = 0; i < n; i++){
            sum += vecX[i] * vecY[i];
        }

        //Ausgabe des Ergebnisses
        System.out.println("Das Skalarprdoukt von x und y ist: " + sum);

    }
}
