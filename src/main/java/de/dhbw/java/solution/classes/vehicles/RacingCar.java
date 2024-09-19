package de.dhbw.java.solution.classes.vehicles;

/**
 * @author DHBW lecturer
 * @version 1.01
 * <p>
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 * <p>
 * (C) 2016 by J. Sidler, T. Schlachter, C. Schmitt, W. Suess
 */
public class RacingCar extends Car {
    public RacingCar() {
        this(0.0);
    }

    public RacingCar(double speed) {
        this(speed, 220.0);
    }

    protected RacingCar(double speed, double maxSpeed) {
        super(speed, maxSpeed);
    }
}
