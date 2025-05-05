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
        System.out.println(item.getTitle() + " 추가되었습니다.");
    }

    public boolean removeItem(String title) {
        for (Publication item : items) {
            if (item.getTitle().equals(title)) {
                items.remove(item);
                System.out.println(title + " 제거되었습니다.");
                return true;
            }
        }
        System.out.println(title + " 찾을 수 없습니다.");
        return false;
    }

    public void displayCart() {
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("--- 장바구니 내용 ---");
        for (Publication item : items) {
            System.out.println(item);
        }
        System.out.println("총 가격: " + df.format(calculateTotalPrice()) + "롤");
        System.out.println("할인 적용 가격: " + df.format(calculateDiscountedPrice()) + "롤");
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
                total += item.getPrice() * 0.9; // 10% 할인
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85; // 15% 할인
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8; // 20% 할인
            } else {
                total += item.getPrice(); // 할인 없음
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

        System.out.println("--- 출판물 통계 분석 ---");
        System.out.println("1. 타입별 평균 가격:");
        System.out.println("- 소설: " + df.format(novelCount > 0 ? novelTotal/novelCount : 0) + "롤");
        System.out.println("- 참고서: " + df.format(refBookCount > 0 ? refBookTotal/refBookCount : 0) + "롤");
        System.out.println("- 잡지: " + df.format(magazineCount > 0 ? magazineTotal/magazineCount : 0) + "롤");

        System.out.println("\n2. 출판물 유형 분포:");
        System.out.println("- 소설: " + df.format((double)novelCount/totalCount*100) + "%");
        System.out.println("- 참고서: " + df.format((double)refBookCount/totalCount*100) + "%");
        System.out.println("- 잡지: " + df.format((double)magazineCount/totalCount*100) + "%");

        System.out.println("\n3. 2007년에 출판된 출판물 비율: " + 
            df.format((double)year2007Count/totalCount*100) + "%");
    }
}
