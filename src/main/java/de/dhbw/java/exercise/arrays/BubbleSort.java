package de.dhbw.java.exercise.arrays;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array;
        int temp;

        //Einlesen der Werte zur Initialisierung des Arrays
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Elemente n eingeben: ");
        int n = sc.nextInt();
        array = new int[n];

        //Speichern der Elemente
        for (int i = 0; i < n; i++){
            System.out.print("Zahl " +i+ " eingeben: ");
            array[i] = sc.nextInt();
        }
        sc.close();

        //BubbleSort
        for(int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
        }
        System.out.print("Sortiert: ");
        for (int j : array) {
            System.out.print(j + " ");
        }

    }
}
