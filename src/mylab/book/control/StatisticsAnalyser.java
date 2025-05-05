package mylab.book.control;

import mylab.book.entity.*;
import java.util.Map;
import java.util.HashMap;
import java.text.DecimalFormat;

public class StatisticsAnalyser {
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> result = new HashMap<>();
        Map<String, Double> typeTotal = new HashMap<>();
        Map<String, Integer> typeCount = new HashMap<>();

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeTotal.put(type, typeTotal.getOrDefault(type, 0.0) + pub.getPrice());
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        for (String type : typeTotal.keySet()) {
            result.put(type, typeTotal.get(type) / typeCount.get(type));
        }

        return result;
    }

    public Map<String, Double> calculateTypeDistribution(Publication[] publications) {
        Map<String, Double> result = new HashMap<>();
        Map<String, Integer> typeCount = new HashMap<>();
        int total = publications.length;

        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }

        for (String type : typeCount.keySet()) {
            result.put(type, (double)typeCount.get(type) / total * 100);
        }

        return result;
    }

    public double calculatePublishedYearRatio(Publication[] publications, String year) {
        int count = 0;
        for (Publication pub : publications) {
            if (pub.getPublishDate().toString().startsWith(year)) {
                count++;
            }
        }
        return (double)count / publications.length * 100;
    }

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "�Ҽ�";
        } else if (pub instanceof Magazine) {
            return "����";
        } else if (pub instanceof ReferenceBook) {
            return "����";
        } else {
            return "��Ÿ";
        }
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        System.out.println("--- ���ǹ� ��� �м� ---");
        
        // 1. Ÿ�Ժ� ��� ����
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        System.out.println("1. Ÿ�Ժ� ��� ����:");
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + df.format(entry.getValue()) + "��");
        }
        
        // 2. ���ǹ� ���� ����
        Map<String, Double> typeDist = calculateTypeDistribution(publications);
        System.out.println("\n2. ���ǹ� ���� ����:");
        for (Map.Entry<String, Double> entry : typeDist.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + df.format(entry.getValue()) + "%");
        }
        
        // 3. 2007�� ���� ����
        double year2007Ratio = calculatePublishedYearRatio(publications, "2007");
        System.out.println("\n3. 2007�⵵�� ���ǵ� ���ǹ� ����: " + df.format(year2007Ratio) + "%");
    }
}