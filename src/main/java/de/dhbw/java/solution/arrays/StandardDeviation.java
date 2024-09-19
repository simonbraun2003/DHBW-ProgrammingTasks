package de.dhbw.java.solution.arrays;

import java.util.Random;
/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by W. Geiger, T. Schlachter, C. Schmitt, W. Süß
 */
public class StandardDeviation {
    public static void main(String[] args) {
        int n = 100;
        Random rnd = new Random();
        int[] x = new int[n];
// generate random numbers and calculate average
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            x[i] = rnd.nextInt(11); // 0..10
            sum += x[i]; // sum up the x[i]
        }
        double average = 1. * sum / n;
        System.out.println("Mittelwert: "+average);
// calculate standard deviation
        double devSum = 0;
        for (int i = 0; i < x.length; i++) {
            devSum += Math.pow(x[i] - average, 2);
        }
        double deviation = Math.sqrt(devSum / (n - 1));
        System.out.println("Standardabweichung: "+deviation);
    }
}
