package de.dhbw.java.exercise.control;

public class MultiplicationTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++){
            for (int j = 1; j <= 10; j++){
                System.out.printf("%4d" , i*j);
                if(j == 10){
                    System.out.print("\n");
                }
            }
        }
    }
}
