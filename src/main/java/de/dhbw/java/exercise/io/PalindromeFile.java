package de.dhbw.java.exercise.io;

import java.io.*;
import java.util.Scanner;

public class PalindromeFile {
    public static void main(String[] args) {
        String reversedInput= "";
        File dir = new File("C:\\Users\\simon\\Documents\\GitHub\\DHBW-ProgrammingTasks\\myDir");
        File palindromesFile = new File(dir,"palindromes.txt");

        //Einlesen des Wortes
        System.out.print("Bitte Wort eingeben: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();

        //Umdrehen des Wortes
        for (int i = input.length(); i > 0; i--) {
            reversedInput += input.charAt(i - 1);
        }
        System.out.println("Umgekehrt: " + reversedInput);
        //Vergleich auf Palindrome
        if(input.equalsIgnoreCase(reversedInput)){
            System.out.println(input + " ist ein Palindrome");

            //Abspeichern des Palindrom in Text-Datei
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(palindromesFile, true))){
                bw.write(input);
                bw.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println(reversedInput + " ist kein Palindrome");
        }
        System.out.println("Alle bisher gefundenen Palindorme:");
        //Ausgabe aller bisher gefundenen Palindorme
        try(BufferedReader br = new BufferedReader(new FileReader(palindromesFile))){
            while (br.ready()){
                String line = br.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
