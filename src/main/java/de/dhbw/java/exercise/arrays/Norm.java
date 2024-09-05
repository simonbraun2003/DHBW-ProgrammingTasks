package de.dhbw.java.exercise.arrays;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Norm {
    public static void main(String[] args) {
        double result = 0;
        double sum = 0;

        //Scanner zum einlesen der Werte
        Scanner sc = new Scanner(System.in);

        //Abfrage und initialisierung der Arraygröße
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = sc.nextInt();
        int[] vec = new int[n];

        //Abfrage der Werte
        for (int i = 0; i < vec.length; i++){
            System.out.print("Bitte x_" + i + " eingeben: ");
            vec[i] = sc.nextInt();
        }
        sc.close();

        //Berechnung des Betrages
        for (int val: vec){
            sum += Math.pow(val, 2);
        }
        result = Math.sqrt(sum);

        //Ausgabe des Ergebnisses
        System.out.println("Der Betrag von x ist: " + result);

    }
}
