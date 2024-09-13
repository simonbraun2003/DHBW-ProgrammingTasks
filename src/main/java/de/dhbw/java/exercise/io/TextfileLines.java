package de.dhbw.java.exercise.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextfileLines {
    public static void main(String[] args) {
        File dir = new File("C:\\Users\\simon\\Documents\\GitHub\\DHBW-ProgrammingTasks\\myDir");
        File file = new File(dir,"textfileLines.txt");
        StringBuilder result = new StringBuilder();


        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            //Eigentliches Auslesen der Datei
            int count = 0;
            while(br.ready()){
                count++;
                String line = br.readLine();
                if (count>=2 && count<=5) {
                    System.out.println(line);
                    result.append(line);
                }
            }
            //Ausgabe der gefundenen Zeilen
            System.out.println("Zeile 2-5: " + result.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
