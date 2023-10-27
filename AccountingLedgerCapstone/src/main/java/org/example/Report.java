package org.example;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Report{
    private TransactionManager transactionManager = new TransactionManager();
    private Ledger ledger = new Ledger();

    public void monthToDateReport() {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();

        List<Transaction> transactions = transactionManager.getAllTransactions();
        ArrayList<Transaction> filteredTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            int transactionYear = transactionDate.getYear();
            int transactionMonth = transactionDate.getMonthValue();

            if (transactionYear == currentYear && transactionMonth == currentMonth) {
                filteredTransactions.add(transaction);
            }
        }
        ledger.displayLedger(filteredTransactions);
    }

    public void previousMonthReport() {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfCurrentMonth = currentDate.withDayOfMonth(1);
        LocalDate firstDayOfPreviousMonth = firstDayOfCurrentMonth.minusMonths(1);

        List<Transaction> transactions = transactionManager.getAllTransactions();
        ArrayList<Transaction> previousMonthTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            if (transactionDate.isAfter(firstDayOfPreviousMonth) && transactionDate.isBefore(firstDayOfCurrentMonth)) {
                previousMonthTransactions.add(transaction);
            }
        }
        ledger.displayLedger(previousMonthTransactions);
    }

    public void yearToDateReport() {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        List<Transaction> transactions = transactionManager.getAllTransactions();
        ArrayList<Transaction> currentYearTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            int transactionYear = transactionDate.getYear();

            if (transactionDate.getYear() == currentDate.getYear()) {
                currentYearTransactions.add(transaction);
            }
        }
        ledger.displayLedger(currentYearTransactions);
    }

    public void previousYearReport() {
        LocalDate currentDate = LocalDate.now();

        LocalDate firstDayOfCurrentYear = LocalDate.of(currentDate.getYear(), 1, 1);

        LocalDate firstDayOfPreviousYear = firstDayOfCurrentYear.minusYears(1);

        ArrayList<Transaction> transactions = new ArrayList<>(transactionManager.getAllTransactions());
        ArrayList<Transaction> previousYearTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());
            if (transactionDate.isAfter(firstDayOfPreviousYear) && transactionDate.isBefore(firstDayOfCurrentYear)) {
                previousYearTransactions.add(transaction);
            }
        }
        ledger.displayLedger(previousYearTransactions);
    }

    public void searchByVendorReport() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter vendor name to search:");
        String vendorName = scnr.nextLine();

        List<Transaction> transactions = transactionManager.getAllTransactions();
        ArrayList<Transaction> vendorTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                vendorTransactions.add(transaction);
            }
        }
        ledger.displayLedger(vendorTransactions);
    }

    public void customSearchReport(){
        Scanner scnr = new Scanner(System.in);
        LocalDate startDate;
        LocalDate endDate = null;
        String description = null;
        String vendor = null;
        double amount = 0;

        System.out.println("**********CUSTOM SEARCH**********");

        System.out.println("Please enter the start date (yyyy-MM-dd) or press Enter to skip: ");
        String startDateInput = scnr.nextLine();
        if(!startDateInput.isEmpty()){
           startDate = LocalDate.parse(startDateInput);
        } else {
            startDate = null;
        }

        System.out.println("Please enter the end date (yyyy-MM-dd) or press Enter to skip: ");
        String endDateInput = scnr.nextLine();
        if(!endDateInput.isEmpty()){
            endDate = LocalDate.parse(endDateInput);
        }

        System.out.println("Please enter the description or press Enter to skip: ");
        String descriptionInput = scnr.nextLine();
        if(!descriptionInput.isEmpty()){
            description = descriptionInput;
        }


        System.out.println("Please enter the vendor name or press Enter to skip: ");
        String vendorInput = scnr.nextLine();
        if(!vendorInput.isEmpty()){
            vendor = vendorInput;
        }

        System.out.println("Please enter the amount or press Enter to skip: ");
        String amountInput = scnr.nextLine();
        if(!amountInput.isEmpty()){
            try{
                amount = Double.parseDouble(amountInput);
            }catch(NumberFormatException ex){
                System.out.println("Invalid amount, please try again");
            }
        }

        List<Transaction> transactions = transactionManager.getAllTransactions();
        ArrayList<Transaction> validTransactions = new ArrayList<>();

        for(Transaction transaction : transactions){
            LocalDate transactionDate = LocalDate.parse(transaction.getDate());

            boolean startDateChecker = (startDateInput.isEmpty() || (transactionDate.isEqual(startDate) || transactionDate.isAfter(startDate)));
            boolean endDateChecker = (endDateInput.isEmpty() || (transactionDate.isBefore(endDate) || transactionDate.isEqual(endDate)));
            boolean descriptionChecker = (descriptionInput.isEmpty() || transaction.getDescription().equalsIgnoreCase(description));
            boolean vendorChecker = (vendorInput.isEmpty() || transaction.getVendor().equalsIgnoreCase(vendor));
            boolean amountChecker = (amount == 0.0 || transaction.getAmount() == amount);

            if(startDateChecker && endDateChecker && descriptionChecker && vendorChecker && amountChecker){
                validTransactions.add(transaction);
            }
        }
        if(validTransactions.isEmpty()){
            System.out.println("No matching transactions found, please try again");
        }
        else{
            System.out.println("**********CUSTOM SEARCH RESULTS**********");
            ledger.displayLedger(validTransactions);
        }
    }
}
