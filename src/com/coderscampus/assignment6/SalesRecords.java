package com.coderscampus.assignment6;

import java.time.YearMonth;

public class SalesRecords {

    private YearMonth date;
    private int sales;

    public SalesRecords(YearMonth date, int sales){
        this.date = date;
        this.sales = sales;
    }

    public YearMonth getDate() {
        return date;
    }

    public void setDate(YearMonth date) {
        this.date = date;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "SalesRecords{" +
                "date=" + date +
                ", sales=" + sales +
                '}';
    }

}
