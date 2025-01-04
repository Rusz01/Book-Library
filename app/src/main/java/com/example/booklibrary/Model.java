package com.example.booklibrary;

public class Model {

    private String bookName;
    private String bookAuthors;
    private String bookPublisher;
    private String bookImage;

    // Default constructor for Firebase
    public Model() {
        // No-op
    }

    public Model(String bookName, String bookAuthors, String bookPublisher, String bookImage) {
        this.bookName = bookName;
        this.bookAuthors = bookAuthors;
        this.bookPublisher = bookPublisher;
        this.bookImage = bookImage;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthors() {
        return bookAuthors;
    }

    public void setBookAuthors(String bookAuthors) {
        this.bookAuthors = bookAuthors;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }
}
