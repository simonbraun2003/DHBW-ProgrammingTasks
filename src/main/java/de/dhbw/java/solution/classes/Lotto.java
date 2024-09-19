package de.dhbw.java.solution.classes;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class Lotto {
    int anzahlZuZiehendeKugeln;
    int gesamtzahlKugeln;
    int[] tipp;
    int[] gezogeneZahlen;
    java.util.Scanner scan;
    Lotto(int m, int n) {
        anzahlZuZiehendeKugeln = m;
        gesamtzahlKugeln = n;
        tipp = new int[anzahlZuZiehendeKugeln];
        gezogeneZahlen = new int[anzahlZuZiehendeKugeln];
        scan = new java.util.Scanner(System.in);
    }
    void spiel() {
        tippen();
        sortiere(tipp);
        ziehen();
        sortiere(gezogeneZahlen);
// Test-Ausgabe
        System.out.println(this.toString());
        System.out.println("Richtige: " + richtige());
    }
    void tippen() {
        boolean eingabeFehler;
        for (int i = 0; i < anzahlZuZiehendeKugeln; i++) {
            do {
                System.out.print("Geben Sie bitte Ihren Tipp für die " + (i + 1)
                        + ". Zahl ein: ");
                eingabeFehler = false;
                tipp[i] = scan.nextInt();
                if ((tipp[i] < 1) || (tipp[i] > 49)) {
                    System.out.println("Eingabefehler: Zahl zu groß oder"
                            + " zu klein.");
                    eingabeFehler = true;
                }
                for (int k = 0; k < i; k++) {
                    if (tipp[k] == tipp[i]) {
                        System.out.println("Eingabefehler: Zahl schon "
                                + "getippt.");
                        eingabeFehler = true;
                    }
                }
            } while (eingabeFehler);
        }
    }
    void sortiere(int[] feld) {
        int temp;
        boolean tausch = true;
        while (tausch) {
            tausch = false;
            for (int i = 0; i < anzahlZuZiehendeKugeln - 1; i++) {
                if (feld[i] > feld[i + 1]) {
                    temp = feld[i];
                    feld[i] = feld[i + 1];
                    feld[i + 1] = temp;
                    tausch = true;
                }
            }
        }
    }
    void ziehen() {
        boolean schonVorhanden;
        for (int i = 0; i < anzahlZuZiehendeKugeln; i++) {
            do {
                schonVorhanden = false;
                gezogeneZahlen[i] = (int) (Math.random() * 49 + 1);
                for (int k = 0; k < i; k++) {
                    if (gezogeneZahlen[k] == gezogeneZahlen[i]) {
                        schonVorhanden = true;
                    }
                }
            } while (schonVorhanden);
        }
    }
    int richtige() {
        int anzRichtige = 0;
        for (int i = 0; i < anzahlZuZiehendeKugeln; i++) {
            for (int k = 0; k < anzahlZuZiehendeKugeln; k++) {
                if (tipp[i] == gezogeneZahlen[k]) {
                    anzRichtige++;
                }
            }
        }
        return anzRichtige;
    }
    public String toString() {
        String str = "";
        if (tipp[0] != 0) {
            str += "Tipp: ";
            for (int i = 0; i < anzahlZuZiehendeKugeln; i++) {
                str = str + tipp[i] + " ";
            }
            str += "\n";
        }
        if (gezogeneZahlen[0] != 0) {
            str += "Gezogene Zahlen: ";
            for (int i = 0; i < anzahlZuZiehendeKugeln; i++) {
                str = str + gezogeneZahlen[i] + " ";
            }
            str += "\n";
        }
        return str;
    }
    public static void main(String[] args) {
        Lotto deutschesLotto = new Lotto(6, 49);
        deutschesLotto.spiel();
    }
}