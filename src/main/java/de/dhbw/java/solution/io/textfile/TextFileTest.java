package de.dhbw.java.solution.io.textfile;

    import java.io.IOException;
    /**
     * @author DHBW lecturer
     * @version 1.0
     *
     * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
     * Cooperative State University.
     *
     * (C) 2016 by J. Sidler, T. Schlachter, C. Schmitt, W. Suess
     */
    public class TextFileTest {
        public static void main(String[]args) throws IOException,
                LineNumberOutOfBoundsException {
            TextFile a = new TextFile("bla.txt");
// Anzahl der Zeilen
            System.out.println("Anzahl der Zeilen: "+a.availableLines());
// Erste Zeile
            System.out.println("Zeile 1: " + a.getLine(1));
// Fünfte Zeile
            System.out.println("Zeile 5: " + a.getLine(5));
// Alle Zeilen
            System.out.println("Alle Zeilen: ");
            for(String line : a.getLines())
                System.out.println(line);
// Ersetzen von "meine" durch "unsre"
            a.replaceAll("meine", "unsre");
// Datei schreiben
// a.write();
            System.out.println("Alle Zeilen nach dem Ersetzen: ");
            for(String line : a.getLines())
                System.out.println(line);
            a.close();
        }
    }
