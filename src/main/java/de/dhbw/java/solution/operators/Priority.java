package de.dhbw.java.solution.operators;

/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class Priority {
    public static void main(String[] args) {
        System.out.println("1: " + (5 / 2 * 2)); //4
        System.out.println("2: " + (9. / 2 * 5)); //22.5
        boolean a = true, b = false, c = false;
        System.out.println("3: " + (a && b || c)); //false
        char ch = 'c';
        System.out.println("4: " + ('a' + 1 < ch)); //true
        int i = 1, j = 2, k = 3;
        System.out.println("5: " + (-i - 5 * j >= k + 1)); //false
        i = 1;
        if (a || (++i == 2)) {
            System.out.println("6: " + i); //1
        }
        i = 1;
        if (a | (++i == 2)) {
            System.out.println("7: " + i); //2
        }
    }
}
