package de.dhbw.java.exercise.arrays;

import java.util.Scanner;

public class MatrixSubtraction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte Anzahl der Zeilen angeben: ");
        int n = sc.nextInt();
        System.out.print("Bitte Anzahl der Spalten angeben: ");
        int m = sc.nextInt();

        int[][] arrayX = new int[n][m];
        int[][] arrayY = new int[n][m];
        int[][] subArray = new int[n][m];

        //Arrays befüllen
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                arrayX[i][j] = (int) (Math.random() * 99);
                arrayY[i][j] = (int) (Math.random() * 99);
            }
        }

        //Array X ausgeben
        System.out.println("X: ");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.printf("%2d ", arrayX[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        //Arrays Y ausgeben
        System.out.println("Y: ");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.printf("%2d ", arrayY[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        //Berechnung des subtrahierten Arrays
        System.out.println("X-Y: ");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                subArray[i][j] = (arrayX[i][j] - arrayY[i][j]);
                System.out.printf("%3d ", subArray[i][j]);
            }
            System.out.println();
        }

    }
}
