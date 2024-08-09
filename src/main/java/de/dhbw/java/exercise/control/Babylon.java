package de.dhbw.java.exercise.control;

import java.util.Scanner;

public class Babylon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Wurzel aus welcher Zahl ziehen? ");
        double a = scan.nextDouble();
        scan.close();
        double xn = 1.0; // randomly selected as x0
        double oldxn;
        do {
            oldxn = xn;
            xn = (xn + (a / xn)) / 2;
        } while (Math.abs(oldxn-xn)>=10E-6);
        System.out.println("Die Wurzel aus " + a + " ist " + xn);
    }
}
