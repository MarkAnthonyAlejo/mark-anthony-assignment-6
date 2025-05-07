package com.coderscampus.assignment6.service;

import com.coderscampus.assignment6.domain.SalesRecord;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesRecordService {
    public void createReport(String modelName, List<SalesRecord> data){
        System.out.println(modelName + " Yearly Sales Report");
        System.out.println("---------------------------");

        Map<Integer, Integer> yearlySales = getYearlySales(data);
        yearlySales.forEach((year, sales) -> System.out.println(year + " -> " + sales));
        SalesRecord bestMonth = getBestMonth(data);
        SalesRecord worstMonth = getWorstMonth(data);
        System.out.println("\nThe best month for " + modelName + " was: " + (bestMonth != null ? bestMonth.getDate() : "N/A"));
        System.out.println("The worst month for " + modelName + " was: " + (worstMonth != null ? worstMonth.getDate() : "N/A"));
        System.out.println();
    }


    private Map<Integer, Integer> getYearlySales(List<SalesRecord> data) {
        return data.stream()
                .collect(Collectors.groupingBy(
                        r -> r.getDate().getYear(),
                        Collectors.summingInt(SalesRecord::getSales)
                ));
    }

    private SalesRecord getBestMonth(List<SalesRecord> data) {
        return data.stream()
                .max(Comparator.comparingInt(SalesRecord::getSales))
                .orElse(null);
    }

    private SalesRecord getWorstMonth(List<SalesRecord> data) {
        return data.stream()
                .min(Comparator.comparingInt(SalesRecord::getSales))
                .orElse(null);

    }
}
