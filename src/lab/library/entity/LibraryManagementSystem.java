package lab.library.entity;

import lab.library.entity.Book;
import lab.library.entity.Library;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // 도서관 생성
        Library library = new Library("Central Library");
        
        // 샘플 도서 추가
        addSampleBooks(library);
        
        // 도서 검색 테스트
        testFindBook(library);
        
        // 도서 대출 테스트
        testCheckOut(library);
    }

    // 샘플 도서 추가 메서드
    public static void addSampleBooks(Library library) {
        library.addBook(new Book("Java Programming", "John Doe", "1234567890", 2020));
        library.addBook(new Book("Clean Code", "Robert Martin", "0987654321", 2008));
        library.addBook(new Book("Design Patterns", "Erich Gamma", "1122334455", 1994));
        System.out.println("Sample books added to the library.");
    }

    // 도서 검색 테스트 메서드
    public static void testFindBook(Library library) {
        String titleToFind = "Clean Code";
        Book foundBook = library.findBookByTitle(titleToFind);
        
        if (foundBook != null) {
            System.out.println("Found book: " + foundBook);
        } else {
            System.out.println("Book with title '" + titleToFind + "' not found.");
        }
    }

    // 도서 대출 테스트 메서드
    public static void testCheckOut(Library library) {
        String isbnToCheckOut = "0987654321"; // Clean Code의 ISBN
        
        // 대출 시도
        boolean checkoutResult = library.checkOutBook(isbnToCheckOut);
        if (checkoutResult) {
            System.out.println("Book with ISBN " + isbnToCheckOut + " checked out successfully.");
        } else {
            System.out.println("Failed to check out book with ISBN " + isbnToCheckOut);
        }
        
        // 대출 가능한 도서 목록 출력
        System.out.println("\nAvailable books after checkout:");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
        }
    }
}