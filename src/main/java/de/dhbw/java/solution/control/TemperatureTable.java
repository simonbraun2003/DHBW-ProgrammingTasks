package de.dhbw.java.solution.control;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class TemperatureTable {
    public static void main(String[] args) {
        System.out.println("Fahrenheit | Celsius");
        System.out.println("-----------+--------");
        for (int fahrenheit=0; fahrenheit<=300; fahrenheit+=20) {
            double celsius = (5./9) * (fahrenheit - 32);
            System.out.printf("%3d | %5.1f",
                    fahrenheit,
                    celsius);
            System.out.println();
        }
    }
}