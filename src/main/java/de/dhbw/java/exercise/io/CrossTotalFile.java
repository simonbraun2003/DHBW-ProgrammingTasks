package de.dhbw.java.exercise.io;

import jdk.jfr.Label;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CrossTotalFile {//Info: ERZEUGEN UND LÖSCHEN VON DATEIEN
    public static void main(String[] args) {
        int cross_total = 0;

        //Einlesen der Zahl
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte Zahl für Quersumme eingeben: ");
        String input = sc.nextLine();
        sc.close();

        //Quersumme berechnen
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            cross_total += Integer.parseInt(String.valueOf(c));
        }

        //Verzeichnis + Datei anlegen zum Speichern des Ergebnisses
        File ctDir = new File("C:\\Users\\simon\\Documents\\GitHub\\DHBW-ProgrammingTasks\\myDir");
        ctDir.mkdir();
        File resFile = new File(ctDir, "cross_total.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(resFile, true))){
            resFile.createNewFile();
            bw.write("Quersumme von " + input + " ist " + cross_total);
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
