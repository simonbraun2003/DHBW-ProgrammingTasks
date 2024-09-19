package de.dhbw.java.solution.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
public class TextfileLines {
    public static void main(String[] args) {
        File textFile = new File("beispiel.txt");
        StringBuilder result = new StringBuilder();
        if (textFile.exists()) {
            try (BufferedReader br = new BufferedReader(
                    new FileReader(textFile)))
            {
                int count = 0;
                while (br.ready()) {
                    count++;
                    String line = br.readLine();
                    if (count>=2 && count<=5) {
                        System.out.println(line);
                        result.append(line);
                    }
                }
                System.out.println("Zeile 2-5: " + result.toString());
            } catch (IOException e) {
                System.err.println("Fehler beim Lesen: " +
                        e.getMessage());
            }
        }
    }
}
