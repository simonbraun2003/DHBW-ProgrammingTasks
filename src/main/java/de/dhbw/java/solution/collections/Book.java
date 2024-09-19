package de.dhbw.java.solution.collections;

/**
 * Part of lectures on 'Programming in Java'. Baden-Wuerttemberg
 * Cooperative State University.
 *
 * (C) 2016-2018 by W. Geiger, T. Schlachter, C. Schmitt, W. Suess
 *
 * @author DHBW lecturer
 * @version 1.1
 */
public class Book {
    public static final int TITLE = 0;
    public static final int AUTHOR = 1;
    public static final int YEAR = 2;
    public static final int PUBLISHER = 3;
    public static final int[] CRITERIA =
            { Book.TITLE, Book.AUTHOR, Book.YEAR, Book.PUBLISHER };
    private String title;
    private String author;
    private int year;
    private String publisher;
    public Book() {
    }
    public Book( String title, String author, int year, String publisher ) {
        super();
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
    }
    @Override
    public String toString() {
        return this.title + ";" + this.author + ";" + this.year + ";"
                + this.publisher;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle( String title ) {
        this.title = title;
    }
    public String getAuthor() {
        return this.author;
    }
    public void setAuthor( String author ) {
        this.author = author;
    }
    public int getYear() {
        return this.year;
    }
    public void setYear( int year ) {
        this.year = year;
    }
    public String getPublisher() {
        return this.publisher;
    }
    public void setPublisher( String publisher ) {
        this.publisher = publisher;
    }
}
