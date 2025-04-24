package lab.library.entity;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;

    // 기본 생성자
    public Book() {
        this.isAvailable = true; // 기본적으로 도서는 대출 가능 상태
    }

    // 매개변수 생성자
    public Book(String title, String author, String isbn, int publishYear) {
        this();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
    }

    // getter & setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // 도서 대출 메서드
    public boolean checkOut() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    // 도서 반납 메서드
    public void returnBook() {
        isAvailable = true;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn 
                + ", publishYear=" + publishYear + ", isAvailable=" + isAvailable + "]";
    }
}