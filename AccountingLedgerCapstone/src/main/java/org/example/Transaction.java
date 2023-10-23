package org.example;

public class Transaction {

    private String date;
    private String time;
    private String vendor;
    private double amount;

    public Transaction(String date, String time, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.vendor = vendor;
        this.amount = amount;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
