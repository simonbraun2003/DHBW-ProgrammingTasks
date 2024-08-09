package de.dhbw.java.exercise.control;

import java.sql.SQLOutput;
import java.util.Scanner;

public class NumberGuess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name;
        int tryCounter = 0;
        int tryNumber;
        int numberToGuess = (int) (Math.random()*100);
        int gameStatus = 1;

        System.out.print("Wie ist dein Name? ");
        name = sc.nextLine();
        System.out.println();

        while (gameStatus == 1) {
            System.out.print(name + ", rate eine Zahl [1-100]: ");
            tryCounter++;
            tryNumber = sc.nextInt();
            if(tryNumber < numberToGuess) {
                System.out.println("Versuch: " + tryCounter + ": " + tryNumber + " ist zu niedrig.");
            }else if(tryNumber > numberToGuess) {
                System.out.println("Versuch: " + tryCounter + ": " + tryNumber + " ist zu hoch.");
            }else {
                System.out.println("Versuch: " + tryCounter + ": " + tryNumber + " ist korrekt.");
                System.out.println("Was möchtest du tun?");
                System.out.println("0 - das Spiel beenden");
                System.out.print("1- Das Spiel forsetzen");

                if(sc.nextInt() == 1) {
                    numberToGuess = (int) (Math.random()*100);
                }else {
                    gameStatus = 0;
                }
            }
        }

    }
}
