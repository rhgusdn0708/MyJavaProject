package workshop.library.entity;

import java.util.ArrayList;
import java.util.List;

public class library {
	private String name;
    private List<book> books;

    public library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(book book) {
        books.add(book);
    }

    public book findBookByTitle(String title) {
        for (book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public book findBookByAuthor(String author) {
        for (book book : books) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public book findBookByISBN(String isbn) {
        for (book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public book checkOutBook(String isbn) {
        book book = findBookByISBN(isbn);
        if (book != null && book.isAvailable()) {
            book.checkOut();
            return book;
        }
        return null;
    }

    public book returnBook(String isbn) {
        book book = findBookByISBN(isbn);
        if (book != null) {
            book.returnBook();
            return book;
        }
        return null;
    }

    public List<book> getAvailableBooks() {
        List<book> available = new ArrayList<>();
        for (book book : books) {
            if (book.isAvailable()) {
                available.add(book);
            }
        }
        return available;
    }

    public List<book> getAllBooks() {
        return books;
    }

    public int getAvailableBooksCount() {
        return getAvailableBooks().size();
    }

    public int getBorrowedBooksCount() {
        return books.size() - getAvailableBooksCount();
    }
}
