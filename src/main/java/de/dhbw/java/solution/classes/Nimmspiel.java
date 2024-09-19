package de.dhbw.java.solution.classes;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg Cooperative
 * State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class Nimmspiel {
    String[] spielerName = new String[2];
    int[] haufen = new int[2];
    java.util.Scanner scan;
    public Nimmspiel(String spieler1, String spieler2) {
        spielerName[0] = spieler1;
        spielerName[1] = spieler2;
        haufen[0] = (int) (Math.random() * 10) + 2;
        haufen[1] = (int) (Math.random() * 10) + 2;
    }
    public void gesamtesSpiel() {
        scan = new java.util.Scanner(System.in);
        int spieler = 1;
        do {
            if (spieler == 0) {
                spieler = 1;
            } else {
                spieler = 0;
            }
            spielzug(spieler);
        } while (!alleKugelnEntfernt());
        System.out.println("Spiel beendet.");
        System.out.println("Gewonnen hat Spieler " + spielerName[spieler]
                + ".");
    }
    public void spielzug(int spielerNr) {
        int haufenNr;
        int gezogeneKugeln;
        boolean eingabeFehler = true;
        do {
            System.out.print("Spieler " + spielerName[spielerNr]
                    + ": Von welchem Haufen ziehen Sie Kugeln? ");
            haufenNr = scan.nextInt() - 1;
            if ((haufenNr < 0) || (haufenNr > 1) || (haufen[haufenNr] == 0)) {
                System.out.println("Eingabefehler! Erneute Eingabe.");
            } else {
                eingabeFehler = false;
            }
        } while (eingabeFehler);
        eingabeFehler = true;
        do {
            System.out.print("Spieler " + spielerName[spielerNr]
                    + ": Wieviele Kugeln ziehen Sie? ");
            gezogeneKugeln = scan.nextInt();
            if ((gezogeneKugeln < 1) || (gezogeneKugeln > haufen[haufenNr])) {
                System.out.println("Eingabefehler! Erneute Eingabe.");
            } else {
                eingabeFehler = false;
            }
        } while (eingabeFehler);
        haufen[haufenNr] -= gezogeneKugeln;
        System.out.println(this);
    }
    public boolean alleKugelnEntfernt() {
        return (haufen[0] == 0) && (haufen[1] == 0);
    }
    public String toString() {
        return "Spieler: " + spielerName[0] + " und " + spielerName[1]
                + ", Haufen 1: " + haufen[0] + " Kugel(n), Haufen 2: "
                + haufen[1] + " Kugel(n)";
    }
    public static void main(String[] args) {
        Nimmspiel spiel = new Nimmspiel("Alf", "Ben");
// Test-Ausgabe
        System.out.println(spiel);
        spiel.gesamtesSpiel();
    }
}