package de.dhbw.java.exercise.collections;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Lottery {
    public static void main(String[] args) {
        //Erstellen des Treesets
        Set<Integer> numbers = new TreeSet<Integer>();

        //Variable zum Speichern der neu hinzuzufügenden Zahl
        Integer numberToAdd = null;
        //Zufallszahl
        Random r = new Random();

        //Zufallszahlen hinzufügen
        while (numbers.size() < 7) {
            //Zufallszahl im bereich von 1 bis 49
            numbers.add(numberToAdd = r.nextInt(49) + 1);
        }

        //entfernen der letzten Nummer für die Bonuszahl
        numbers.remove(numberToAdd);

        //Ausgabe der Erstellten zahlen
        for(Integer no: numbers){
            System.out.print(no + " ");
        }

        System.out.println("Bonuszahl: " + numberToAdd);

    }
}
