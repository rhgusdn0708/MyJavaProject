package workshop.library.control;

import workshop.library.entity.book;
import workshop.library.entity.library;

public class librarymanagementsystem {
    public static void main(String[] args) {
        library library = new library("중앙도서관");

        addSampleBooks(library);

        System.out.println("[전체 도서 목록]");
        for (book book : library.getAllBooks()) {
            System.out.println(book);
        }

        testFindBook(library);
        testCheckOut(library);
        testReturn(library);

        displayAvailableBooks(library);
    }

    private static void addSampleBooks(library library) {
        library.addBook(new book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
        library.addBook(new book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
        library.addBook(new book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new book("자연의 역사", "남궁동", "978-89-01-40747-4", 2019));
    }

    private static void testFindBook(library library) {
        System.out.println("\n[도서 검색 테스트]");
        System.out.println("제목으로 검색: " + library.findBookByTitle("자바 프로그래밍"));
        System.out.println("저자로 검색: " + library.findBookByAuthor("조영호"));
        System.out.println("ISBN으로 검색: " + library.findBookByISBN("978-0-13-235088-4"));
    }

    private static void testCheckOut(library library) {
        System.out.println("\n[도서 대출 테스트]");
        book book = library.checkOutBook("978-0-13-235088-4");
        if (book != null) {
            System.out.println("대출 성공: " + book);
        } else {
            System.out.println("대출 실패: 해당 도서를 찾을 수 없거나 이미 대출 중입니다.");
        }
    }

    private static void testReturn(library library) {
        System.out.println("\n[도서 반납 테스트]");
        book book = library.returnBook("978-0-13-235088-4");
        if (book != null) {
            System.out.println("반납 성공: " + book);
        } else {
            System.out.println("반납 실패: 해당 도서를 찾을 수 없습니다.");
        }
    }

    private static void displayAvailableBooks(library library) {
        System.out.println("\n[대출 가능한 도서 목록]");
        for (book book : library.getAvailableBooks()) {
            System.out.println(book);
        }
    }
}
