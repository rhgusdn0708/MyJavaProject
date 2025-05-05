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
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        System.out.println("--- 출판물 통계 분석 ---");
        
        // 1. 타입별 평균 가격
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        System.out.println("1. 타입별 평균 가격:");
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + df.format(entry.getValue()) + "롤");
        }
        
        // 2. 출판물 유형 분포
        Map<String, Double> typeDist = calculateTypeDistribution(publications);
        System.out.println("\n2. 출판물 유형 분포:");
        for (Map.Entry<String, Double> entry : typeDist.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + df.format(entry.getValue()) + "%");
        }
        
        // 3. 2007년 출판 비율
        double year2007Ratio = calculatePublishedYearRatio(publications, "2007");
        System.out.println("\n3. 2007년도에 출판된 출판물 비율: " + df.format(year2007Ratio) + "%");
    }
}