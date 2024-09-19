package de.dhbw.java.solution.datatypes;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2016 by J. Sidler, T. Schlachter, C. Schmitt, W. Suess
 */
public class Round {
    public static void main(String[] args) {
        double pi = 3.1415926; // Naeherung der Kreiszahl Pi
        double e = 2.7182818; // Naeherung der Eulerschen Zahl e
// Positive Zahlen
        System.out.println("Runden positiver Zahlen");
        int piInt = (int) (pi + 0.5);
        int eInt = (int) (e + 0.5);
        System.out.println("Pi ganzzahlig: " + piInt); // Ausgabe: 3
        System.out.println("e ganzzahlig: " + eInt); // Ausgabe: 3
// Naiver Versuch mit negativen Zahlen:
        System.out.println("Runden negativer Zahlen (fehlerhaft)");
        pi = -pi;
        e = -e;
        piInt = (int) (pi + 0.5);
        eInt = (int) (e + 0.5);
        System.out.println("-Pi ganzzahlig: " + piInt); // Ausgabe: -2
        System.out.println("-e ganzzahlig: " + eInt); // Ausgabe: -2
// So klappt es negativ wie positiv
        System.out.println("Runden pos. und negativer Zahlen (korrekt)");
// pi und e sind noch negativ
        piInt = (int) (pi + ( (pi>0) ? 0.5 : -0.5));
        eInt = (int) (e + ( (e>0) ? 0.5 : -0.5));
        System.out.println("-Pi ganzzahlig: " + piInt); // Ausgabe: -3
        System.out.println("-e ganzzahlig: " + eInt); // Ausgabe: -3
// pi und e sind positiv machen
        pi = -pi;
        e = -e;
        piInt = (int) (pi + ( (pi>0) ? 0.5 : -0.5));
        eInt = (int) (e + ( (e>0) ? 0.5 : -0.5));
        System.out.println("Pi ganzzahlig: " + piInt); // Ausgabe: 3
        System.out.println("e ganzzahlig: " + eInt); // Ausgabe: 3
    }
}
