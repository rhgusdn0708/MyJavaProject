package mylab.book.entity;

import java.time.LocalDate;

public class Novel extends Publication {
    private String author;
    private String genre;

    public Novel(String title, LocalDate publishDate, int page, double price, String author, String genre) {
        super(title, publishDate, page, price);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("%s [�Ҽ�] ����:%s, ����:%s, %d��, %.0f��, ������:%s",
                title, author, genre, page, price, publishDate);
    }

    // Getters
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
}