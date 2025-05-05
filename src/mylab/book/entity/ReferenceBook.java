package mylab.book.entity;

import java.time.LocalDate;

public class ReferenceBook extends Publication {
    private String field;

    public ReferenceBook(String title, LocalDate publishDate, int page, double price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    @Override
    public String toString() {
        return String.format("%s [잡고서] 높아 오프트웨어:%s, %d롤, %.0f롤, 출판일:%s",
                title, field, page, price, publishDate);
    }

    // Getters
    public String getField() { return field; }
}