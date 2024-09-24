package de.dhbw.java.solution.enums;

import java.util.Calendar;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public enum Months {
    JANUARY("Januar", 31, "Hartung, Eismond"),
    FEBRUARY("Februar", 28,
            "Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester"),
    MARCH("M\u00E4rz", 31, "Lenzing, Lenzmond"),
    APRIL("April", 30, "Launing, Ostermond"),
    MAY("Mai", 31, "Winnemond*, Blumenmond"),
    JUNE("Juni", 30, "Brachet, Brachmond"),
    JULY("Juli", 31, "Heuert, Heumond"),
    AUGUST("August", 31, "Ernting, Erntemond, Bisemond"),
    SEPTEMBER("September", 30, "Scheiding, Herbstmond"),
    OCTOBER("Oktober", 31, "Gilbhart, Gilbhard, Weinmond"),
    NOVEMBER("November", 30, "Nebelung, Windmond, Wintermond"),
    DECEMBER("Dezember", 31, "Julmond, Heilmond, Christmond, Dustermond");
    private String name;
    private int days;
    private String altNames;
    private Months( String name, int days, String altNames ) {
        this.name = name;
        this.days = days;
        this.altNames = altNames;
    }
    @Override
    public String toString() {
        return "Der " + this.name + " hat " + this.days
                + " Tage und hie\u00DF fr\u00FCher '" + this.altNames + "'";
    }
    public String getName() {
        return this.name;
    }
    public int getDays() {
        return this.days;
    }
    public String getAltNames() {
        return this.altNames;
    }
    public static void main( String[] args ) {
        int thisMonth = Calendar.getInstance().get( Calendar.MONTH );
        for ( Months month : Months.values() ) {
            if ( month.ordinal() == thisMonth ) {
                System.out.println( month );
            }
        }
        System.out.println( Months.values()[thisMonth] );
    }
}