package lab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private String name;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // 도서 추가
    public void addBook(Book book) {
        books.add(book);
    }

    // 제목으로 도서 검색
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // ISBN으로 도서 대출
    public boolean checkOutBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                return book.checkOut();
            }
        }
        return false;
    }

    // ISBN으로 도서 반납
    public boolean returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isAvailable()) {
                book.returnBook();
                return true;
            }
        }
        return false;
    }

    // 대출 가능한 도서 목록 조회
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // Getter
    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}