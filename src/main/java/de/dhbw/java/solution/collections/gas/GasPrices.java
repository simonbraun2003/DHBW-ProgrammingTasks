package de.dhbw.java.solution.collections.gas;

public class GasPrices {
    private double diesel;
    private double superE5;
    private double superE10;
    public double getDiesel() {
        return diesel;
    }
    public void setDiesel(double diesel) {
        this.diesel = diesel;
    }
    public double getSuperE5() {
        return superE5;
    }
    public void setSuperE5(double superE5) {
        this.superE5 = superE5;
    }
    public double getSuperE10() {
        return superE10;
    }
    public void setSuperE10(double superE10) {
        this.superE10 = superE10;
    }
    @Override
    public String toString() {
        return "Diesel: " + this.diesel + ", SuperE5: " + this.superE5
                + ", SuperE10: " + this.superE10;
    }
}
