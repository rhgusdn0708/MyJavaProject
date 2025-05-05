package mylab.book.entity;

import java.time.LocalDate;

public class Magazine extends Publication {
    private String publishPeriod;

    public Magazine(String title, LocalDate publishDate, int page, double price, String publishPeriod) {
        super(title, publishDate, page, price);
        this.publishPeriod = publishPeriod;
    }

    @Override
    public String toString() {
        return String.format("%s [����] �߹��ֱ�:%s, %d��, %.0f��, ������:%s",
                title, publishPeriod, page, price, publishDate);
    }

    // Getters
    public String getPublishPeriod() { return publishPeriod; }
}