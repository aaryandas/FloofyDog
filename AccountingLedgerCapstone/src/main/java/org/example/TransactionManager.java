package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionManager {
    public ArrayList<Transaction> transactions = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    private void AddDeposit(){
        System.out.println("Enter the date (yyyy-MM-dd): ");
        String date = scanner.nextLine();
        System.out.println("Enter the time (HH:mm:ss): ");
        String time = scanner.nextLine();
        System.out.println("Enter the description: ");
        String description = scanner.nextLine();
        System.out.println("Enter the vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        transactions.add(new Transaction(date, time, description, vendor, amount));
        System.out.println("Deposit added successfully!");
    }

    private void MakePayment(Transaction payment) {
        System.out.println("Making Payment");
        System.out.println("Enter the date (yyyy-MM-dd): ");
        String date = scanner.nextLine();
        System.out.println("Enter the time (HH:mm:ss): ");
        String time = scanner.nextLine();
        System.out.println("Enter the description: ");
        String description = scanner.nextLine();
        System.out.println("Enter the vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Enter the amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        transactions.add(new Transaction(date, time, description, vendor, amount));
        System.out.println("Payment added successfully.");
    }

    public ArrayList<Transaction> LoadTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<>();

        try{
            FileInputStream fis = new FileInputStream("src/main/resources/transactions.csv");

            Scanner scnr = new Scanner(fis);
            scnr.nextLine();

            String input;
            while(scnr.hasNextLine()){
                input = scnr.nextLine();
                String[] rowArray = input.split("\\|");

                Transaction transaction = new Transaction(rowArray[0], rowArray[1], rowArray[2], rowArray[3], Double.parseDouble(rowArray[4]));

                transactions.add(transaction);
            }

        }
        catch(FileNotFoundException ex){
            System.out.println("Transaction file was not found");
        }

        return transactions;
    }

}
