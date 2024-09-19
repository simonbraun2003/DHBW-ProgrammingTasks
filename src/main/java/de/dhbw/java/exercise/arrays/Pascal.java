package de.dhbw.java.exercise.arrays;

public class Pascal {

    //Alle Werte des Dreiecks berechnen
    public static int[][] calculatePascalEntries(int n){
        int[][] pascalEntries = new int[n][n];

        //Erster Eintrag ist immer 1
        pascalEntries[0][0] = 1;

        //Beginnend ab der zweiten Zeile
        for (int i = 1; i < n; i++){
            //Der erste Eintrag jeder Zeile ist 1
            pascalEntries[i][0] = 1;
            for (int j = 1; j < n; j++){
                pascalEntries[i][j] = pascalEntries[i - 1][j - 1] + pascalEntries[i - 1][j];
            }
        }
        return pascalEntries;
    }

    public static void printEntries(int[][] pascalEntries, int n){
        //Zeilen
        for (int i=0; i<n; i++){
            //Leerzeichen
            for (int j=0; j<n-i; j++){
                System.out.print(" ");
            }
            //Einträge
            for (int j=0; j<=i; j++){
                System.out.print(pascalEntries[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printEntries(calculatePascalEntries(5), 5);
    }
}
