package de.dhbw.java.exercise.control;

public class TemperatureTable {
    public static void main(String[] args) {

        System.out.println("Fahrenheit  |  Celsius");
        System.out.println("------------+---------");
        for (int f = 0; f <= 300; f += 20) {
            double celsius = (5 / 9.) * (f - 32);
            System.out.printf("%3d         | %3.1f \n", f, celsius);
        }
    }
}
