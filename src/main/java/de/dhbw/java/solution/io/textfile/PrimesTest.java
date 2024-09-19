package de.dhbw.java.solution.io.textfile;

import de.dhbw.java.solution.io.PrimesFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2016 by J. Sidler, T. Schlachter, C. Schmitt, W. Suess
 */
public class PrimesTest {
    public static void main(String[] args) {
        boolean[] prim = loadPrimes(PrimesFile.PRIM_FILENAME);
        if (prim!=null && prim.length>0) {
            Random rnd = new Random();
// Test for 10 random numbers if they are prime
            for (int i=0; i<10; i++) {
                int number = rnd.nextInt(prim.length);
                System.out.println(number + " is " +
                        (prim[number]?"":"not ") + "prime.");
            }
        }
    }
    public static boolean[] loadPrimes(String filename) {
        boolean[] prim = new boolean[PrimesFile.MAX];
// read lines using try-with-resources statement
        try (BufferedReader br2 = new BufferedReader(new FileReader(
                new File(filename)))) {
            while (br2.ready()) {
                prim[Integer.parseInt(br2.readLine())] = true;
            }
        } catch (IOException e) {
            System.err.println("Error reading from "+filename);
        }
        return prim;
    }
}
