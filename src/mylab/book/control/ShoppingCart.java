package mylab.book.control;

import mylab.book.entity.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class ShoppingCart {
    private ArrayList<Publication> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Publication item) {
        items.add(item);
        System.out.println(item.getTitle() + " �߰��Ǿ����ϴ�.");
    }

    public boolean removeItem(String title) {
        for (Publication item : items) {
            if (item.getTitle().equals(title)) {
                items.remove(item);
                System.out.println(title + " ���ŵǾ����ϴ�.");
                return true;
            }
        }
        System.out.println(title + " ã�� �� �����ϴ�.");
        return false;
    }

    public void displayCart() {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("--- ��ٱ��� ���� ---");
        for (Publication item : items) {
            System.out.println(item);
        }
        System.out.println("�� ����: " + df.format(calculateTotalPrice()) + "��");
        System.out.println("���� ���� ����: " + df.format(calculateDiscountedPrice()) + "��");
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public double calculateDiscountedPrice() {
        double total = 0;
        for (Publication item : items) {
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9; // 10% ����
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85; // 15% ����
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8; // 20% ����
            } else {
                total += item.getPrice(); // ���� ����
            }
        }
        return total;
    }

    public void printStatistics() {
        int novelCount = 0, magazineCount = 0, refBookCount = 0;
        double novelTotal = 0, magazineTotal = 0, refBookTotal = 0;
        int year2007Count = 0;

        for (Publication item : items) {
            if (item instanceof Novel) {
                novelCount++;
                novelTotal += item.getPrice();
            } else if (item instanceof Magazine) {
                magazineCount++;
                magazineTotal += item.getPrice();
            } else if (item instanceof ReferenceBook) {
                refBookCount++;
                refBookTotal += item.getPrice();
            }

            if (item.getPublishDate().getYear() == 2007) {
                year2007Count++;
            }
        }

        int totalCount = items.size();
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("--- ���ǹ� ��� �м� ---");
        System.out.println("1. Ÿ�Ժ� ��� ����:");
        System.out.println("- �Ҽ�: " + df.format(novelCount > 0 ? novelTotal/novelCount : 0) + "��");
        System.out.println("- ����: " + df.format(refBookCount > 0 ? refBookTotal/refBookCount : 0) + "��");
        System.out.println("- ����: " + df.format(magazineCount > 0 ? magazineTotal/magazineCount : 0) + "��");

        System.out.println("\n2. ���ǹ� ���� ����:");
        System.out.println("- �Ҽ�: " + df.format((double)novelCount/totalCount*100) + "%");
        System.out.println("- ����: " + df.format((double)refBookCount/totalCount*100) + "%");
        System.out.println("- ����: " + df.format((double)magazineCount/totalCount*100) + "%");

        System.out.println("\n3. 2007�⿡ ���ǵ� ���ǹ� ����: " + 
            df.format((double)year2007Count/totalCount*100) + "%");
    }
}
