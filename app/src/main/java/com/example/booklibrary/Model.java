package com.example.booklibrary;

import java.io.Serializable;

public class Model implements Serializable {

    private String bookName;
    private String bookAuthors;
    private String bookPublisher;
    private String bookImage;
    private String startDate;
    private String endDate;


    public Model() {
        // No-op
    }


    public Model(String bookName, String bookAuthors, String bookPublisher, String bookImage, String startDate, String endDate) {
        this.bookName = bookName;
        this.bookAuthors = bookAuthors;
        this.bookPublisher = bookPublisher;
        this.bookImage = bookImage;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
