package mylab.book.entity;

import java.time.LocalDate;

public class Publication {
    protected String title;
    protected LocalDate publishDate;
    protected int page;
    protected double price;

    public Publication() {}

    public Publication(String title, LocalDate publishDate, int page, double price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    @Override
    public String toString() {
        return title;
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public LocalDate getPublishDate() { return publishDate; }
    public int getPage() { return page; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}