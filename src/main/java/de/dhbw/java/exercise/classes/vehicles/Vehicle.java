package de.dhbw.java.exercise.classes.vehicles;

public class Vehicle {
    int wheel = 0;

    double vMax = 0;
    double pos;
    double vel;

    public Vehicle(int wheel, double vMax, double vel) {
        this.wheel = wheel;
        this.vMax = vMax;
        this.setSpeed(vel);
    }

    //Methode zum setzen der Geschwindigkeit
    public void setSpeed(double speed) {
        if(vel + speed > vMax) vel = vMax - speed;
    }

    //Methode um Vehicle zu bewegen
    public void drive(double minutes){
        if(vel > 0){
            vel = pos + (vel * (minutes / 60));
        }

    }

    //Informationsausgabe
    public String toString(){
        return "at position " + pos + " with " + wheel + " wheels at speed " + vel + " km/h of max. " + vMax;
    }

}
