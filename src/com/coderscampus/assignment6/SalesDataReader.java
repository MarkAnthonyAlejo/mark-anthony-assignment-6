package com.coderscampus.assignment6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class SalesDataReader {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMM-yy", Locale.US);

    public static List<SalesRecords> readData(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(",");
                    YearMonth date = YearMonth.parse(parts[0], FORMATTER);
                    int sales = Integer.parseInt(parts[1]);
                    return new SalesRecords(date,sales);
                })
                .collect(Collectors.toList());
    }

}
