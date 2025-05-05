package workshop.library.control;

import workshop.library.entity.book;
import workshop.library.entity.library;

public class librarymanagementsystem {
    public static void main(String[] args) {
        library library = new library("�߾ӵ�����");

        addSampleBooks(library);

        System.out.println("[��ü ���� ���]");
        for (book book : library.getAllBooks()) {
            System.out.println(book);
        }

        testFindBook(library);
        testCheckOut(library);
        testReturn(library);

        displayAvailableBooks(library);
    }

    private static void addSampleBooks(library library) {
        library.addBook(new book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new book("�ڿ��� ����", "���õ�", "978-89-01-40747-4", 2019));
    }

    private static void testFindBook(library library) {
        System.out.println("\n[���� �˻� �׽�Ʈ]");
        System.out.println("�������� �˻�: " + library.findBookByTitle("�ڹ� ���α׷���"));
        System.out.println("���ڷ� �˻�: " + library.findBookByAuthor("����ȣ"));
        System.out.println("ISBN���� �˻�: " + library.findBookByISBN("978-0-13-235088-4"));
    }

    private static void testCheckOut(library library) {
        System.out.println("\n[���� ���� �׽�Ʈ]");
        book book = library.checkOutBook("978-0-13-235088-4");
        if (book != null) {
            System.out.println("���� ����: " + book);
        } else {
            System.out.println("���� ����: �ش� ������ ã�� �� ���ų� �̹� ���� ���Դϴ�.");
        }
    }

    private static void testReturn(library library) {
        System.out.println("\n[���� �ݳ� �׽�Ʈ]");
        book book = library.returnBook("978-0-13-235088-4");
        if (book != null) {
            System.out.println("�ݳ� ����: " + book);
        } else {
            System.out.println("�ݳ� ����: �ش� ������ ã�� �� �����ϴ�.");
        }
    }

    private static void displayAvailableBooks(library library) {
        System.out.println("\n[���� ������ ���� ���]");
        for (book book : library.getAvailableBooks()) {
            System.out.println(book);
        }
    }
}
