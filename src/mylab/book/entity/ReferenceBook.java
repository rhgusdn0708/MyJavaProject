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
        return String.format("%s [���] ���� ����Ʈ����:%s, %d��, %.0f��, ������:%s",
                title, field, page, price, publishDate);
    }

    // Getters
    public String getField() { return field; }
}