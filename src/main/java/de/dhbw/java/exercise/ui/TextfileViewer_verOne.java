package de.dhbw.java.exercise.ui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextfileViewer_verOne {

    private static final int MAX_LINES = 10;

    public TextfileViewer_verOne(File file) {
        JFrame frame = new JFrame(file.getName());
        String[] content = TextfileViewer_verOne.readTextfile(file);


        /*
        Auswahl der minimalen Zeilenanzahl (Entweder Textdatei sehr klein oder maximal die Anzahl die in Variable
        festgelegt wurde)
        */
        final int displayLines =
                    Math.min(content.length, TextfileViewer_verOne.MAX_LINES);

        //Layout für Frame festlegen (Darstellung der Textdatei durch JLabel pro Zeile)
        frame.setLayout(new GridLayout(displayLines, 1));
        for (int i = 0; i < displayLines; i++) {
            frame.add(new JLabel(content[i]));
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setVisible(true);
    }

    public static String[] readTextfile(File file) {
        //Zeilen zählen für Arraygröße (Nötig, da Arrays mit fester Größe erzeugt werden müssen)
        int lines = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            while (br.ready()){
                lines++;
                br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Array mit der Größe der Anzahl der Zeilen erstellen
        String[] contents = new String[lines];
        lines = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            while(br.ready()){
                contents[lines++] = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contents;
    }

    public static void main(String[] args) {
        //Filechooser wie in der Vorlesung vorgestellt
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() ||
                        f.getName().toLowerCase().endsWith(".txt");
            }
            @Override
            public String getDescription() {
                return "Text Files";
            }
        });
        int state = fc.showOpenDialog(null);
        if (state == JFileChooser.APPROVE_OPTION){
            new TextfileViewer_verOne(fc.getSelectedFile());
        } else {
            JOptionPane.showMessageDialog(null, "Choice cancelled");
        }
    }
}
