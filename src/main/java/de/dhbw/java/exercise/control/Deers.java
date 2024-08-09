package de.dhbw.java.exercise.control;

public class Deers {
    public static void main(String[] args) {
        int vNumberOfDeers = 200;
        int yearCount = 1;

        while(vNumberOfDeers < 300){
            vNumberOfDeers = ((int) (vNumberOfDeers + vNumberOfDeers*0.1)) - 15;
            System.out.println(yearCount +": " + vNumberOfDeers);
            yearCount++;
        }
    }
}
