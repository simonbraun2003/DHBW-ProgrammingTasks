package de.dhbw.java.solution.control;

import java.util.Scanner;
/**
 * @author DHBW lecturer
 * @version 1.0
 *
 * Part of lectures on 'Programming in Java'.
 * Baden-Wuerttemberg Cooperative State University.
 *
 * (C) 2015 by J. Sidler, T. Schlachter, C. Schmitt, W. Süß
 */
public class NumberGuess {
    public static void main(String[] args) {
        int limit = 100;
        int end;
        Scanner scan = new Scanner(System.in);
        String bestPlayer = "";
        int leastTrials = -1; // negativer Wert: bisher wurde noch kein
// Spiel durchgeführt
        do {
            int numberToGuess = (int) (Math.random() * limit + 1);
// System.out.println("#### Zu erratende Zahl: "
// + zuErratendeZahl + " ####");
            int trials = 0;
            boolean guessed = false;
            System.out.print("Geben Sie bitte Ihren Namen ein: ");
            String name = scan.next();
            do {
                System.out.print("Geben Sie bitte eine Zahl aus dem Bereich "
                        + "1 und 100 ein: ");
                int tip = scan.nextInt();
                trials++;
                if (tip > numberToGuess) {
                    System.out.println("Versuch Nr. " + trials + ": " + tip
                            + " zu hoch!");
                } else if (tip < numberToGuess) {
                    System.out.println("Versuch Nr. " + trials + ": " + tip
                            + " zu niedrig!");
                } else {
                    System.out.println("Versuch Nr. " + trials
                            + ": Sie haben die Zahl erraten!!!");
                    guessed = true;
                    if ((leastTrials<0) | (trials<leastTrials)) {
                        leastTrials = trials;
                        bestPlayer = name;
                    }
                }
            } while (!guessed);
            do {
                System.out.print("Wollen Sie das Spiel beenden (0), fortsetzen "
                        + "(1) oder den bisher besten Spieler(in) ausgeben "
                        + "lassen (2)? ");
                end = scan.nextInt();
                if ((end<0) || (end>2))
                    System.out.println("Eingabefehler!");
                if (end == 2) {
                    System.out.println("Bisher beste/r Spieler/in: "
                            + bestPlayer
                            + ", geringste Anzahl Versuche: "
                            + leastTrials);
                }
            } while ((end<0) || (end>1));
        } while (end == 1);
    }
}