package com.coderscampus.assignment6;

import java.io.IOException;
import java.util.List;

public class SalesReportApp {
    public static void main(String[] args) {

        try {
            List<SalesRecords> model3 = SalesDataReader.readData("model3.csv");
            List<SalesRecords> modelS = SalesDataReader.readData("modelS.csv");
            List<SalesRecords> modelX = SalesDataReader.readData("modelX.csv");

            SalesAnalyzer.createReport("Model 3", model3);
            SalesAnalyzer.createReport("Model S", modelS);
            SalesAnalyzer.createReport("Model X", modelX);
        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }

    }
}
