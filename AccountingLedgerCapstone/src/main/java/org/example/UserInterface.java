package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class UserInterface {
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private static final String transactionFile = "transactions.csv";
    private Scanner scanner = new Scanner(System.in);
    private Ledger ledger;


    public void homeScreen(){
        loadTransactionsFromFile(transactionFile);
        boolean isDisplaying = true;

        while(isDisplaying){
            displayHomeScreenOptions();
            int userInput = scanner.nextInt();
            scanner.nextLine();

            try{
                switch(userInput){
                    case 1:
                        System.out.println("You chose to add a deposit!");
                        addDeposit();
                        break;
                    case 2:
                        System.out.println("You chose to make a payment!");
                        addPayment();
                        break;
                    case 3:
                        displayLedgerScreen();
                        break;
                    case 4:
                        System.out.println("See you next time!");
                        isDisplaying = false;
                        break;
                    default:
                        System.out.println("That's not an option, sorry");
                }
            }
            catch(Exception ex){
                System.out.println("That's not an option, sorry");
                scanner.nextLine();
            }
        }
    }

    public void displayHomeScreenOptions(){

        System.out.println("Welcome! Please choose one of the following options: ");
        System.out.println("1) Add Deposit");
        System.out.println("2) Make Payment");
        System.out.println("3) Display Ledger");
        System.out.println("4) Exit the application");

    }

    private void addDeposit(){
        System.out.println("Enter deposit details: ");
        System.out.println("Please enter the date of transaction (yyyy-mm-dd): ");
        String date = scanner.nextLine();
        System.out.println("Please enter the time of transaction (hh-mm-ss): ");
        String time = scanner.nextLine();
        System.out.println("Please enter a description of the transaction: ");
        String description = scanner.nextLine();
        System.out.println("Please enter the name of the vendor: ");
        String vendor = scanner.nextLine();
        System.out.println("Please enter the transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        Transaction deposit = new Transaction(date, time, description, vendor, amount);
            transactions.add(deposit);
            System.out.println("Deposit added successfully");
    }

    private void addPayment(){
        System.out.println("Enter deposit details (date, time, description, vendor, amount): ");
        String[] paymentDetails = scanner.nextLine().split("\\|");
        if(paymentDetails.length == 5){
            Transaction payment = new Transaction(
                    paymentDetails[0], paymentDetails[1], paymentDetails[2], paymentDetails[3], Double.parseDouble(paymentDetails[4])
            );
            transactions.add(payment);
            System.out.println("Payment added successfully");
        }else{
            System.out.println("Invalid input format. Please use date|time|description|vendor|amount");
        }
    }

    private void displayLedgerScreen() {
        Ledger ledger = new Ledger(transactions);

        boolean isDisplaying = true;
        while (isDisplaying) {

            System.out.println("**********LEDGER SCREEN**********");
            System.out.println("1) All Entries: Displays all transactions");
            System.out.println("2) Deposits: Displays deposits");
            System.out.println("3) Payments: Displays payments");
            System.out.println("4) Reports: Run a custom search");
            System.out.println("5) Go back");

            System.out.println("Choose an option: ");
            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch(userInput){
                case 1:
                    ledger.displayAll();
                    break;
                case 2:
                    ledger.displayDeposits();
                    break;
                case 3:
                    ledger.displayPayments();
                    break;
                case 4:
                    System.out.println("Reports are not implemented yet");
                    break;
                case 5:
                    isDisplaying = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void loadTransactionsFromFile(String filename){
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split("\\|");
                if(parts.length == 5){
                    transactions.add(new Transaction(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading transactions: " + e.getMessage());
        }
    }

    private void saveTransactionsToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Transaction transaction : transactions) {
                writer.write(transaction.toString());
                writer.newLine();
            }
            System.out.println("Transactions saved to " + filename);
        } catch (IOException ex) {
            System.out.println("Error saving transactions: " + ex.getMessage());
        }
    }


    public void displayReportsScreen(){

        System.out.println("**********REPORTS SCREEN**********");
        System.out.println("1) Month to Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year to Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("6) Go Back");

        int userInput = scanner.nextInt();
        scanner.nextLine();

        switch(userInput){
            case 1:
                //monthToDate
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Enter vendor name to search: ");
                String searchVendor = scanner.nextLine();
                ledger.displayReports(searchVendor);
                break;
            case 6:

        }



    }


}
