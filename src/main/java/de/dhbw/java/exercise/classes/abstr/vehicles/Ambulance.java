package de.dhbw.java.exercise.classes.abstr.vehicles;

public class Ambulance extends Car {
    boolean bluelight = false;

    public Ambulance(double vel, boolean bluelight) {
        super(vel);
        this.bluelight = bluelight;
    }

    public void turnOnLight(){
        bluelight = true;
    }

    public void turnOffLight(){
        bluelight = false;
    }
}
