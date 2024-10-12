package de.dhbw.java.probeklausur;

import java.awt.*;
import java.util.Random;

public class Account {

    private String name;
    private Color color;
    private State state = State.AVAILABLE;

    public Account(String name) {
        Random r = new Random();
        this.color= new Color(r.nextInt(201), r.nextInt(201), r.nextInt(201));
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public State getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setState(State state) {
        this.state = state;
    }
}
