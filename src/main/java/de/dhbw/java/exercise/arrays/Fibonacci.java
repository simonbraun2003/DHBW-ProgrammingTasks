package de.dhbw.java.exercise.arrays;

public class Fibonacci {
    public static void main(String[] args) {
        //Array für 20 Werte anlegen
        int[] fib = new int[20];

        //Erste beiden Stellen mit Werte befüllen
        fib[0] = fib[1] = 1;

        //Restliches Array befüllen
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        //Ergebnis Ausgeben
        for (int i = 0; i < fib.length; i++) {
            System.out.printf("%2d.: %d",i,fib[i]);
            System.out.println();
        }
    }
}
