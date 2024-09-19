package de.dhbw.java.exercise.classes.periodic;

public class Metal extends Element{

    private boolean metalloid;
    private double conductivity;

    public Metal(String name, String symbol, int ordinal, char shell, int phase, boolean hOrNGroup,
                 boolean metalloid, double conductivity) {
        super(name, symbol, ordinal, shell, phase, hOrNGroup);
        this.metalloid = metalloid;
        this.conductivity = conductivity;
    }
    @Override
    public String toString() {
        if(metalloid){
            return super.toString() + metalloid + ", " + this.conductivity;
        }else{
            return super.toString();
        }
    }

    public void setConductivity(double conductivity) {
        this.conductivity = conductivity;
    }

    public void setMetalloid(boolean metalloid) {
        this.metalloid = metalloid;
    }

    public boolean isMetalloid() {
        return metalloid;
    }

    public double getConductivity() {
        return conductivity;
    }
}
