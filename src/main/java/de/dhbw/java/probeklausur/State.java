package de.dhbw.java.probeklausur;


public enum State {
    AVAILABLE("Available"),
    AWAY("AWAY"),
    DND("DO not distriurb");

    private final String label;

    State(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }
}
