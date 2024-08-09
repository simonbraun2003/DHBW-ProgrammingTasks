package de.dhbw.java.exercise.control;

public class ShoeSize {
    public static void main(String[] args) {
        System.out.println("Zentimeter | Größe");
        System.out.println("--------------+------");
        for (int size=30; size<50; size++) {
            double length = size / 1.5;
            System.out.printf("%5.2f - %5.2f | %2d",
                    (length - 2./3),
                    length,
                    size);
            System.out.println();
        }
    }
}
