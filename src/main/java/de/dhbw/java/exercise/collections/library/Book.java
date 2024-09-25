package de.dhbw.java.exercise.collections.library;

public class Book {
    private int publishingYear;
    private String title;
    private String author;
    private String Publisher;

    public Book(int publishingYear, String title, String author, String Publisher) {
        this.publishingYear = publishingYear;
        this.title = title;
        this.author = author;
        this.Publisher = Publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return Publisher;
    }
}
