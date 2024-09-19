package de.dhbw.java.solution.collections;

import java.util.Comparator;
/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.0
 */
public class BookComparator implements Comparator<Book> {
    private int order; // Selects Attribute to compare
    public BookComparator( int order ) {
        this.order = order;
    }
    @Override
    public int compare( Book b1, Book b2 ) {
        switch (this.order) {
            case Book.TITLE: return b1.getTitle().compareTo( b2.getTitle() );
            case Book.AUTHOR: return b1.getAuthor().compareTo( b2.getAuthor() );
            case Book.YEAR: return b1.getYear() - b2.getYear();
            case Book.PUBLISHER:
                return b1.getPublisher().compareTo( b2.getPublisher() );
        }
        return 0;
    }
}
