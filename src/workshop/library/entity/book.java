package workshop.library.entity;

public class book {
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable = true;

    public book() {}

    public book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getPublishYear() { return publishYear; }
    public boolean isAvailable() { return isAvailable; }

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
        }
    }

    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return title + ", " + author + ", " + isbn + ", " + publishYear + ", Available: " + isAvailable;
    }
}
