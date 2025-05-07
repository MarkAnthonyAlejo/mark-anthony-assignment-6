package com.coderscampus.assignment6.service;

import com.coderscampus.assignment6.domain.SalesRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class FileService {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM-yy", Locale.US);

    public List<SalesRecord> readData(String filePath) {
        List<SalesRecord> records = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            bufferedReader.readLine();
            while((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                YearMonth date = YearMonth.parse(data[0], FORMATTER);
                int sales = Integer.parseInt(data[1]);
                SalesRecord salesRecord = new SalesRecord(date, sales);
                records.add(salesRecord);
            }

        } catch (IOException e) {
            System.out.println("Ooops, there was an error reading the file. The error is: " + e.getMessage());
        }
        return records;
    }
}
