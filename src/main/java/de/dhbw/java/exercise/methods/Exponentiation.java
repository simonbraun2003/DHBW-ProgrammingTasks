package de.dhbw.java.exercise.methods;

import java.util.Scanner;

public class Exponentiation {
    
    //Berechnung der Werte
    public static double xPowerN(double x, int n){
        double answer = 0;
        if(n == 0) answer = 1;
        else if (n > 0) {
            answer = x * xPowerN(x, n-1);
        }
        return answer;
    }

    //Test
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Bitte wählen Sie eine zahl für die Basis: ");
        int basis = sc.nextInt();
        System.out.print("Wählen Sie einen positiven Ganzzahligen Exponent: ");
        int exp = sc.nextInt();
        System.out.println(xPowerN(basis, exp));
    }
}
