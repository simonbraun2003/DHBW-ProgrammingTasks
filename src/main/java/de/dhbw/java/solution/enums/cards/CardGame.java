package de.dhbw.java.solution.enums.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class CardGame {
    private List<PlayingCard> deck;
    public CardGame() {
        this.deck = new ArrayList<>();
        for ( Suit f : Suit.values() ) {
            for ( CardValue w : CardValue.values() ) {
                this.deck.add( new PlayingCard( f, w ) );
            }
        }
    }
    public void shuffle() {
        Collections.shuffle( this.deck );
    }
    public void sort() {
        Collections.sort( this.deck );
    }
    public PlayingCard get() {
        if ( this.deck.isEmpty() ) {
            return null;
        }
        return this.deck.remove( 0 );
    }
    public List<PlayingCard> all() {
        return this.deck;
    }
}