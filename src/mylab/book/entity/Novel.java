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
        return String.format("%s [소설] 저자:%s, 공문:%s, %d롤, %.0f롤, 출판일:%s",
                title, author, genre, page, price, publishDate);
    }

    // Getters
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
}