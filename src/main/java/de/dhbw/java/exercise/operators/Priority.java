package de.dhbw.java.exercise.operators;

public class Priority {
    public static void main(String[] args) {
        System.out.println("1: " + (5 / 2 * 2));
        System.out.println("2: " + (9. / 2 * 5)); //erst div dann mult.
        boolean a = true, b = false, c = false;
        System.out.println("3: " + (a && b || c)); //erst AND dann OR.
        char ch = 'c';
        System.out.println("4: " + ('a' + 1 < ch)); //erst < dann add.
        int i = 1, j = 2, k = 3;
        System.out.println("5: " + (-i - 5 * j >= k + 1)); //erst >= dann mult dann add / subt.
        i = 1;
        if (a || (++i == 2)) {
            System.out.println("6: " + i); //Ausführen der Verzwigung nach Überprüfung von a.
        }
        i = 1;
        if (a | (++i == 2)) {
            System.out.println("7: " + i); //Ausführen der Verzwigung erst nach Überprüfung beider Bedingungen.
        }
    }
}
