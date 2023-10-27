package org.example;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;

public class TransactionManager {
    private static final String TRANSACTION_FILE = "src/main/resources/transactions.txt";
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";
    private ArrayList<Transaction> transactions = new ArrayList<>();


    public void addTransaction(String date, String time, String description, String vendor, double amount, boolean isDeposit) {
        if (!isValidDateFormat(date)) {
            System.out.println("Invalid date format. Please use 'yyyy-mm-dd'");
            return;
        }

        if (!isValidTimeFormat(time)) {
            System.out.println("Invalid time format. Please use 'hh:mm:ss'");
            return;
        }

        if (amount == 0) {
            System.out.println("Invalid deposit amount. Amount cannot be zero");
            return;
        }

        if (description.trim().isEmpty() || vendor.trim().isEmpty()) {
            System.err.println("Description and vendor cannot be empty.");
            return;
        }

        if (!isDeposit) {
            amount = -amount;
        }

        Transaction deposit = new Transaction(date, time, description, vendor, amount);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTION_FILE, true))) {
            writer.write(deposit.toString());
            writer.newLine();
            System.out.println("Transaction added successfully");
        } catch (IOException ex) {
            System.out.println("Error adding deposit: " + ex.getMessage());
        }
    }


    private boolean isValidDateFormat(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException ex) {
            return false;
        }
    }

    private boolean isValidTimeFormat(String time){
            try {
                LocalTime.parse(time);
                return true;
            }
            catch(DateTimeParseException ex){
                return false;
            }
    }

    public List<Transaction> getAllTransactions(){
        return readTransactionsFromFile();
    }

    public List<Transaction> getDeposits(){
        List<Transaction> allTransactions = readTransactionsFromFile();
        List<Transaction> deposits = new ArrayList<>();

        for (Transaction transaction : allTransactions){
            if(transaction.getAmount() > 0){
                deposits.add(transaction);
            }
        }
        return deposits;
    }

    public List<Transaction> getPayments(){
        List<Transaction> allTransactions = readTransactionsFromFile();
        List<Transaction> payments = new ArrayList<>();

        for (Transaction transaction : allTransactions){
            if(transaction.getAmount() < 0){
                payments.add(transaction);
            }
        }
        return payments;
    }

    public List<Transaction> readTransactionsFromFile(){
        transactions.clear();

        try{
            BufferedReader reader =  new BufferedReader(new FileReader(TRANSACTION_FILE));

            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split("\\|");
                if(parts.length == 5){
                    String date = parts[0];
                    String time = parts[1];
                    String description = parts[2];
                    String vendor = parts[3];
                    double amount = Double.parseDouble(parts[4]);

                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    transactions.add(transaction);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return transactions;
    }
}





