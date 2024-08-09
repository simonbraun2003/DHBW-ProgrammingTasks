package de.dhbw.java.exercise.datatypes;

public class Round {
    public static void main(String[] args) {
        double pi = 3.1415926; // Naeherung der Kreiszahl Pi
        double e = 2.7182818; // Naeherung der Eulerschen Zahl e


        System.out.println("Runden pos. und negativer Zahlen (korrekt)");
        // pi und e sind noch negativ
        int piInt = (int) (pi + ( (pi>0) ? 0.5 : -0.5));
        int eInt = (int) (e + ( (e>0) ? 0.5 : -0.5));
        System.out.println("Pi ganzzahlig: " + piInt); // Ausgabe: 3
        System.out.println("e ganzzahlig: " + eInt); // Ausgabe: 3
        // pi und e sind positiv
        pi = -pi;
        e = -e;
        piInt = (int) (pi + ( (pi>0) ? 0.5 : -0.5));
        eInt = (int) (e + ( (e>0) ? 0.5 : -0.5));
        System.out.println("-Pi ganzzahlig: " + piInt); // Ausgabe: -3
        System.out.println("-e ganzzahlig: " + eInt); // Ausgabe: -3
    }
}