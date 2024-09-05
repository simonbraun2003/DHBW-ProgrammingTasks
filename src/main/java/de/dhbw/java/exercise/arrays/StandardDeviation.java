package de.dhbw.java.exercise.arrays;

public class StandardDeviation {
    public static void main(String[] args) {
        int summe = 0;
        double mittelwert;
        double zwischenwert = 0;
        double standardabweichung;

        //Array mit gewünchter Größe Anlegen
        final int arrayGroeße = 100;
        int[] array = new int[arrayGroeße];

        //Array mit Werten füllen
        for(int i=0; i<array.length; i++){
            array[i] = (int) (Math.random() * (10) + 0);
        }

        //Summe des Arrays berechnen
        for (int value : array) {
            summe += value;
        }

        //Mittwelwert berechnen
        mittelwert = (1.0/array.length) * summe;


        //Zwischenberechnung
        for(int value : array){
            zwischenwert = zwischenwert + Math.pow((value-mittelwert), 2);
        }

        //Standardabweichung berechnen
        standardabweichung = Math.sqrt((1.0/(array.length-1)) * zwischenwert);

        //Ausgabe
        System.out.println("Mittelwert: " + mittelwert);
        System.out.println("Standardabweichung: " + standardabweichung);
    }
}
