package de.dhbw.java.exercise.classes.periodic;

public class Element {

    private String name;
    private String symbol;
    private int ordinal;
    private char shell;
    private int phase;
    private boolean hOrNGroup;

    final static int SOLID = 1;
    final static int LIQUID = 2;
    final static int GAS = 3;

    final static boolean MAIN = true;
    final static boolean SIDE  = false;

    public Element(String name, String symbol, int ordinal, char shell, int phase, boolean hOrNGroup) {
        this.name = name;
        this.symbol = symbol;
        this.ordinal = ordinal;
        this.shell = shell;
        this.phase = phase;
        this.hOrNGroup = hOrNGroup;
    }

    public boolean equals(Object o){
        return o instanceof Element && ((Element) o).getOrdinal() == ordinal;
    }

    public String toString() {
        return name + " (" + symbol + ", " + ordinal + ") Schale: " + shell + ", " + phase + ", Gruppe: " + (hOrNGroup ? "Hauptgruppe" : "Nebengruppe");
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getOrdinal() {
        return ordinal;
    }

    public char getShell() {
        return shell;
    }

    public int getPhase() {
        return phase;
    }

    public boolean ishOrNGroup() {
        return hOrNGroup;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setOrdinal(int ordinal) {
        this.ordinal = ordinal;
    }

    public void setShell(char shell) {
        this.shell = shell;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public void sethOrNGroup(boolean hOrNGroup) {
        this.hOrNGroup = hOrNGroup;
    }
}
