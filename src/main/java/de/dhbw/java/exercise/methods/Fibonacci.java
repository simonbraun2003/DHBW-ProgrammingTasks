package de.dhbw.java.exercise.methods;

import java.util.Scanner;

public class Fibonacci {
    //Test
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Fibonacci zahlen berechnen?");
        int anzahl = scanner.nextInt();
        for(int i = 0; i < anzahl; i++){
            System.out.println("F("+ (i+1) +") " + fibonacci(i));
        }
    }

    //Berechnung der Fibonacci Reihe
    public static int fibonacci(int a) {
        if(a == 0) return 0;
        else if (a == 1 || a == 2) return 1;
        else return fibonacci(a - 1) + fibonacci(a - 2);
    }

}
