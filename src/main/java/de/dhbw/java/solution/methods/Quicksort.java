package de.dhbw.java.solution.methods;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class Quicksort {
    public static void quicksort(int[] daten, int links, int rechts) {
        if (links < rechts) {
            int teiler = teile(daten, links, rechts);
            quicksort(daten, links, teiler - 1);
            quicksort(daten, teiler + 1, rechts);
        }
    }
    public static int teile(int[] daten, int links, int rechts) {
        int i = links;
        int j = rechts - 1;
        int pivot = daten[rechts];
        do {
// Suche von links ein Element, das größer als das Pivot ist
            while (daten[i] <= pivot && i < rechts) {
                i++;
            }
// Suche von rechts ein Element, das kleiner als das Pivot ist
            while (daten[j] >= pivot && j > links) {
                j--;
            }
            if (i < j) {
// tausche daten[i] mit daten[j]
                int temp = daten[i];
                daten[i] = daten[j];
                daten[j] = temp;
            }
        } while (i < j); // solange i an j nicht vorbeigelaufen ist
// Tausche das Pivotelement mit seiner endgültigen Position i
        if (daten[i] > pivot) {
// tausche daten[i] mit daten[rechts]
            int temp = daten[i];
            daten[i] = daten[rechts];
            daten[rechts] = temp;
        }
// gib die Position des Pivotelements zurück
        return i;
    }
    public static void sort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }
    public static void main(String[] args) {
// Testlauf
        int[] array = {9, 2, 5, 7, 8, 3, 4, 10, 1, 6};
        System.out.println("Unsortierte Zahlenfolge:");
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("\n\nSortierte Zahlenfolge:");
        sort(array);
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }
}