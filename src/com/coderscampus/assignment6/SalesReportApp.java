package com.coderscampus.assignment6;

import com.coderscampus.assignment6.domain.SalesRecord;
import com.coderscampus.assignment6.service.FileService;
import com.coderscampus.assignment6.service.SalesRecordService;

import java.io.IOException;
import java.util.List;

public class SalesReportApp {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        SalesRecordService salesRecordService = new SalesRecordService();
        String[] models = {"3","S","X"};

        for (String model : models){
            List<SalesRecord> record = fileService.readData("model" + model +".csv");
            salesRecordService.createReport("Model " + model, record);
        }
    }
}
