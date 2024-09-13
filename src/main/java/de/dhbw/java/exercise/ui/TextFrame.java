package de.dhbw.java.exercise.ui;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextFrame {

    JFrame frame;

    //Konstruktor zur Erstellung der Oberfläche
    public TextFrame(File file, int width, int height) {
        //Initalisierung JFrame
        frame = new JFrame();
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(file.getName());

        //Erstellen und Hinzufügen der benötigten Komponenten
        JTextArea textArea = new JTextArea();
        //Lesen der Datei und Einfügen in JTextArea
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while(br.ready()){
                String line = br.readLine();
                textArea.append(" " + line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //TextArea JFrame hinzufügen
        frame.add(textArea);

        //JFrame sichtbar machen
        frame.setVisible(true);
    }

    //Test-Methode
    public static void main(String[] args) {
        //Anlegen der Datei falls nicht vorhanden
        /*
        Aufgabe sollte über Kommandozeilenparameter bearbeitet werden zur vereinfachung hier ohne -> Bsp. in der
        Musterlösung
        */
        File dir = new File("C:\\Users\\simon\\Documents\\GitHub\\DHBW-ProgrammingTasks\\myDir");
        File palindromesFile = new File(dir,"palindromes.txt");

        //Erstellen des Fensters über Konstruktoraufruf
        TextFrame textFrame = new TextFrame(palindromesFile, 400, 400);
    }
}
