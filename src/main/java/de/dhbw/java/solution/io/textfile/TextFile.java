package de.dhbw.java.solution.io.textfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016 by J. Sidler, T. Schlachter, C. Schmitt, W. Suess
 */
public class TextFile {
    /** File zum Lesen und Schreiben */
    private File f;
    private String[] buffer;
    /** Konstruktor mit File */
    public TextFile(File f) {
        this.f = f;
        this.read();
    }
    /** Konstruktor mit String als Pfadname */
    public TextFile(String filename) {
        this(new File(filename));
    }
    /** Datei (erneut) einlesen. Wirft keine Exception! */
    public void read() {
        int zeilen = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(f))) {
            for (; in.ready(); zeilen++)
                in.readLine();
        } catch (IOException e) {
            System.err.println("Fehler bein Lesen der Datei.");
        }
        buffer = new String[zeilen];
        try (BufferedReader in = new BufferedReader(new FileReader(f))) {
            for (int i = 0; i < zeilen; i++)
                buffer[i] = in.readLine();
        } catch (IOException e) {
            System.err.println("Fehler bein Lesen der Datei.");
        }
    }
    /** Datei schreiben. Wirft Exception! */
    public void write() {
        if (buffer != null)
            try (PrintWriter out = new PrintWriter(new FileWriter(f))) {
                for (int i = 0; i < buffer.length; i++)
                    out.println(buffer[i]);
            } catch (IOException e) {
                System.err.println("Fehler beim write()");
            }
    }
    /** Liefert die Anzahl der Zeilen. */
    public int availableLines() {
        if (buffer == null)
            return -1;
        return buffer.length;
    }
    /** Liefert alle Zeilen als Array. */
    public String[] getLines() {
        return buffer;
    }
    /** Liefert die angegeben Zeile. Zählung ab 1. */
    public String getLine(int i) throws LineNumberOutOfBoundsException {
        if (buffer == null)
            return null;
        if (i > 0 && i <= buffer.length)
            return buffer[i - 1];
        else
            throw new LineNumberOutOfBoundsException(
                    "Falsche Eingabe bei getLine");
    }
    /** Ersetzt die angegeben Zeile. Zählung ab 1. */
    public void setLine(int i, String s)
            throws LineNumberOutOfBoundsException {
        if (buffer != null && i > 0 && i <= buffer.length)
            buffer[i - 1] = s;
        else
            throw new LineNumberOutOfBoundsException(
                    "Falsche Eingabe bei setLine");
    }
    /** Ersetzt alle Vorkommen von regexp in allen Zeilen durch ersatz */
    public void replaceAll(String regexp, String ersatz) {
        if (buffer != null && regexp != null && ersatz != null)
            for (int i = 0; i < buffer.length; i++)
                buffer[i] = buffer[i].replaceAll(regexp, ersatz);
    }
    /** Löscht den Puffer und das Filehandle */
    public void close() {
        buffer = null;
        this.f = null;
    }
}