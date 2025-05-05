package com.coderscampus.assignment6;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesAnalyzer {
    public static void createReport(String modelName, List<SalesRecords> data){
        System.out.println(modelName + " Yearly Sales Report");
        System.out.println("----------------");

        Map<Integer, Integer> yearlySales = data.stream()
                .collect(Collectors.groupingBy(
                        r -> r.getDate().getYear(),
                        Collectors.summingInt(SalesRecords::getSales)
                ));

        yearlySales.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println(entry.getKey() + "->" + entry.getValue()));


        SalesRecords bestMonth = data.stream()
                                     .max(Comparator.comparingInt(SalesRecords::getSales))
                                     .orElse(null);

        SalesRecords worstMonth = data.stream()
                                      .min(Comparator.comparingInt(SalesRecords::getSales))
                                      .orElse(null);

        System.out.println("\nThe best month for " + modelName + " was: " + (bestMonth != null ? bestMonth.getDate() : "N/A"));
        System.out.println("The worst month for " + modelName + " was: " + (worstMonth != null ? worstMonth.getDate() : "N/A"));
        System.out.println("-----------------------------");
    }
}
