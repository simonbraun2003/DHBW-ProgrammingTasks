package de.dhbw.java.solution.enums.cards;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class PlayingCard implements Comparable<PlayingCard> {
    private Suit suit;
    private CardValue value;
    public PlayingCard() {
    }
    public PlayingCard( Suit suit, CardValue value ) {
        this.suit = suit;
        this.value = value;
    }
    @Override
    public String toString() {
        return this.suit + " " + this.value;
    }
    @Override
    public int compareTo( PlayingCard ok ) {
        return (Integer.valueOf( this.getOrderValue() )
                .compareTo( ok.getOrderValue() ));
    }
    private int getOrderValue() {
        return this.suit.ordinal() * 10 + this.value.ordinal();
    }
    public Suit getSuit() {
        return this.suit;
    }
    public void setSuit( Suit suit ) {
        this.suit = suit;
    }
    public CardValue getValue() {
        return this.value;
    }
    public void setValue( CardValue value ) {
        this.value = value;
    }
}
