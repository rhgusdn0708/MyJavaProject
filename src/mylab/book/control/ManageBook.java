package mylab.book.control;

import mylab.book.entity.*;
import java.time.LocalDate;

public class ManageBook {
    public static void main(String[] args) {
        // ���ǹ� �迭 ���� �� �ʱ�ȭ
        Publication[] publications = new Publication[] {
            new Magazine("����ũ�ν���Ʈ", LocalDate.of(2007, 10, 1), 325, 9600, "�̹�"),
            new Magazine("�۾�����Ʃ��", LocalDate.of(2007, 10, 3), 316, 9000, "�̹�"),
            new Novel("��������", LocalDate.of(2007, 7, 1), 396, 8900, "�����Ʈ���κ���", "�ϴѽ���"),
            new Novel("��ǰ���", LocalDate.of(2007, 4, 14), 395, 11000, "����", "�ϴѽ���"),
            new ReferenceBook("�м��������α׷���", LocalDate.of(2007, 1, 14), 496, 8900, "���"),
            new Novel("�ż��̷д�", LocalDate.of(2014, 5, 1), 216, 15000, "ȯ��", "��ֽ���"),
            new Novel("��������ʴ´�", LocalDate.of(2021, 9, 8), 335, 15100, "ȯ��", "��ֽ���")
        };

        // ���ǹ� ���� ���
        System.out.println("--- ���� ���� ��� ---");
        for (int i = 0; i < publications.length; i++) {
            System.out.println((i+1) + ". " + publications[i]);
        }

        // Ư�� ���ǹ� ���� ����
        Publication target = publications[6]; // "��������ʴ´�"
        double originalPrice = target.getPrice();
        modifyPrice(target);
        System.out.println("\n--- ���� ���� ---");
        System.out.println(target.getTitle() + " ���� �� ����: " + (int)originalPrice + "��");
        System.out.println(target.getTitle() + " ���� �� ����: " + (int)target.getPrice() + "��");
        System.out.println("����: " + (int)(originalPrice - target.getPrice()) + "��");

        // ��� �м� ����
        StatisticsAnalyser analyser = new StatisticsAnalyser();
        analyser.printStatistics(publications);

        // ���� īƮ �׽�Ʈ
        ShoppingCart cart = new ShoppingCart();
        for (Publication pub : publications) {
            cart.addItem(pub);
        }
        cart.displayCart();
        cart.printStatistics();
        cart.removeItem("��ǰ���");
        cart.displayCart();
    }

    public static void modifyPrice(Publication pub) {
        if (pub instanceof Magazine) {
            pub.setPrice(pub.getPrice() * 0.6); // 40% ����
        } else if (pub instanceof Novel) {
            pub.setPrice(pub.getPrice() * 0.8); // 20% ����
        } else if (pub instanceof ReferenceBook) {
            pub.setPrice(pub.getPrice() * 0.9); // 10% ����
        }
    }
}