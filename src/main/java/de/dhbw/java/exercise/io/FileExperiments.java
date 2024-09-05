package de.dhbw.java.exercise.io;

import java.io.File;
import java.io.IOException;

public class FileExperiments {
    public static void main(String[] args) {

        //Vwerzeichniss Anlegen
        File dir = new File("C:\\Users\\simon\\Documents\\GitHub\\DHBW-ProgrammingTasks\\myDir");
        dir.mkdir();

        //Dateien anlegen und hinzufügen#
        File[] files = new File[3];
        for (int i = 0; i < 3; i++) {
            files[i] = new File(dir, "foo"+(i+1)+".txt");
            try{
                files[i].createNewFile();
            } catch (IOException e) {
                System.err.println("Error creating file " + files[i].getAbsolutePath());
            }
        }

        //Auflisten der vorhandenen Dateien
        for (File f: dir.listFiles()) {
            System.out.println(f.getAbsolutePath());
        }

        //Dateien wieder löschen
        for (File f: files) {
            //f.delete();
        }

    }
}
