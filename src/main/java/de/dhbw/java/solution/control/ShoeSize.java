package de.dhbw.java.solution.control;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class ShoeSize {
    public static void main(String[] args) {
        System.out.println("Zentimeter | Größe");
        System.out.println("--------------+------");
        for (int size=30; size<50; size++) {
            double length = size / 1.5;
            System.out.printf("%5.2f - %5.2f | %2d",
                    (length - 2./3),
                    length,
                    size);
            System.out.println();
        }
    }
}
