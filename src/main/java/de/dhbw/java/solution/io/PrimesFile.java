package de.dhbw.java.solution.io;

import java.io.File;
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
public class PrimesFile {
    public static final int MAX = 100000;
    public static final String PRIM_FILENAME = "primes.txt";
    public static void main(String[] args) {
        savePrimes(getPrimes(MAX), PRIM_FILENAME);
        System.out.println("prime numbers up to " + MAX + " saved to " +
                PRIM_FILENAME);
    }
    public static void savePrimes(boolean[] prim, String filename) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(
                    new File(filename)));
            for (int i = 0; i < prim.length; i++) {
                if (prim[i])
                    pw.println(i);
            }
            pw.close();
        } catch (IOException e) {
            System.err.println("Error writing numbers to " + filename);
        }
    }
    public static boolean[] getPrimes(int max) {
        boolean[] prim = new boolean[max];
// initialize array with true
        for (int i = 2; i < prim.length; i++)
            prim[i] = true;
// eratostenes' sieve
        for (int i = 2; i < prim.length; i++)
            if (prim[i])
                for (int j = i * 2; j < prim.length; j += i)
                    prim[j] = false;
        return prim;
    }
}