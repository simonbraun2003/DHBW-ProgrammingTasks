package de.dhbw.java.exercise.datatypes;

public class ShortValue {

    static short vShort = 32767;

    public static void main(String[] args) {
        System.out.println(vShort); //32767
        vShort +=1;
        System.out.println(vShort); //-32768 -> Speicherbereich voll nach +1 somit erneuter beginn von hinten
    }
}
