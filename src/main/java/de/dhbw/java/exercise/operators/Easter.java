package de.dhbw.java.exercise.operators;

import java.util.Scanner;

public class Easter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int k = year / 100;
        int p = (8*k+13) / 25;
        int q = k / 4;
        int m = (15+k-p-q)  % 30;
        int n = (4+k-q) % 7;
        int d = (19*a+m) % 30;
        int e = (2*b+4*c+6*d+n) % 7;
        int easter = (22+d+e);

        System.out.println("Im Jahr " + year +
                " ist der Ostersonntag am "+
                (easter<32 ? easter : easter-31) + ". " +
                (easter<32 ? "März" : "April"));
    }
}
