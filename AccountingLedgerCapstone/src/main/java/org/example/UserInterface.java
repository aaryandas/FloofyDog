package org.example;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UserInterface {
    private TransactionManager transactionManager = new TransactionManager();
    private Ledger ledger = new Ledger();

    public void homeScreen(){

        boolean isDisplaying = true;
        boolean invalidOptionEntered = false;
        Scanner scnr = new Scanner(System.in);

        while(isDisplaying){

            homeScreenOptions();

            try {
                int userInput = scnr.nextInt();

                switch (userInput) {
                    case 1:
                        addDeposit();
                        break;
                    case 2:
                        makePayment();
                        break;
                    case 3:
                        displayLedger();
                        break;
                    case 0:
                        System.out.println("Exiting the application. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("That's not an option, please try again");
                }
            }
            catch(Exception ex){
                invalidOptionEntered = true;
                scnr.nextLine();
            }
            if(invalidOptionEntered){
                System.out.println("That's not an option, sorry");
                invalidOptionEntered = false;
            }
        }

    }
    private void homeScreenOptions(){
        System.out.println("Welcome to the Accounting Ledger Application!");
        System.out.println("**********HOME MENU**********");
        System.out.println("1) Add Deposit");
        System.out.println("2) Make Payment");
        System.out.println("3) Access Ledger");
        System.out.println("0) Exit application");
    }

    private void addDeposit() {
        boolean isDisplayingDepositScreen = true;
        Scanner scnr = new Scanner(System.in);

        while (isDisplayingDepositScreen) {
            try {
                System.out.println("Please enter the following information to add a deposit: ");

                System.out.println("Date (yyyy-mm-dd): ");
                String date = scnr.nextLine();

                System.out.println("Time (hh:mm:ss): ");
                String time = scnr.nextLine();

                System.out.println("Description: ");
                String description = scnr.nextLine();

                System.out.println("Vendor: ");
                String vendor = scnr.nextLine();

                System.out.println("Amount: ");
                double amount = scnr.nextDouble();

                transactionManager.addTransaction(date, time, description, vendor, amount, true);

                isDisplayingDepositScreen = false;
            } catch (Exception ex) {
                System.out.println("You can't do that!");
            }
        }
    }
    private void makePayment() {
        boolean isDisplayingDepositScreen = true;
        Scanner scnr = new Scanner(System.in);

        while (isDisplayingDepositScreen) {
            try {
                System.out.println("Please enter the following information to add a payment: ");

                System.out.println("Date (yyyy-mm-dd): ");
                String date = scnr.nextLine();

                System.out.println("Time (hh-mm-ss): ");
                String time = scnr.nextLine();

                System.out.println("Description: ");
                String description = scnr.nextLine();

                System.out.println("Vendor: ");
                String vendor = scnr.nextLine();

                System.out.println("Amount: ");
                double amount = scnr.nextDouble();

                transactionManager.addTransaction(date, time, description, vendor, amount, false);

                isDisplayingDepositScreen = false;
            } catch (Exception ex) {
                System.out.println("You can't do that!");
            }
        }
    }

    private void displayLedger() {
        Scanner scnr = new Scanner(System.in);
        while (true) {
            System.out.println("**********LEDGER MENU**********");
            System.out.println("1) All Transactions");
            System.out.println("2) Deposits");
            System.out.println("3) Payments");
            System.out.println("4) Reports");
            System.out.println("0) Back to Home");
            System.out.print("Enter your choice: ");

            int choice = scnr.nextInt();
            scnr.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    displayAllTransactions();
                    break;
                case 2:
                    displayDeposits();
                    break;
                case 3:
                    displayPayments();
                    break;
                case 4:
                    displayReports();
                    break;
                case 0:
                    return; // Return to the home screen
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private void displayReports() {
        boolean isDisplayingReports = true;
        Scanner scnr = new Scanner(System.in);

        while (isDisplayingReports) {
            // Display available reports
            System.out.println("**********REPORTS MENU**********");
            System.out.println("1) Month to Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("0) Back to Ledger");

            int reportChoice = scnr.nextInt();
            scnr.nextLine();

            switch (reportChoice) {
                case 1:
                    displayMonthToDateReport();
                    break;
                case 2:
                    displayPreviousMonthReport();
                    break;
                case 3:
                    displayYearToDateReport();
                    break;
                case 4:
                    displayPreviousYearReport();
                    break;
                case 5:
                    displaySearchByVendorReport();
                    break;
                case 0:
                    isDisplayingReports = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayAllTransactions() {
        // Read and display all transactions from the CSV file
        ArrayList<Transaction> allTransactions = new ArrayList<>(transactionManager.getAllTransactions());
        ledger.displayLedger(allTransactions);
    }

    private void displayDeposits() {
        // Read and display deposit transactions from the CSV file
        ArrayList<Transaction> deposits = new ArrayList<>(transactionManager.getDeposits());
        ledger.displayLedger(deposits);
    }

    private void displayPayments() {
        // Read and display payment transactions from the CSV file
        ArrayList<Transaction> payments = new ArrayList<>(transactionManager.getPayments());
        ledger.displayLedger(payments);
    }

    private void displayMonthToDateReport() {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();

        // Filter transactions for the current month
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

    private void displayPreviousMonthReport() {
        LocalDate currentDate = LocalDate.now();
        LocalDate firstDayOfCurrentMonth = currentDate.withDayOfMonth(1);
        LocalDate firstDayOfPreviousMonth = firstDayOfCurrentMonth.minusMonths(1);

        // Filter transactions for the previous month
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

    private void displayYearToDateReport() {
        // Calculate and display transactions for the current year
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        // Filter transactions for the current year
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

    private void displayPreviousYearReport() {
        // Calculate and display transactions for the previous year
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the first day of the current year
        LocalDate firstDayOfCurrentYear = LocalDate.of(currentDate.getYear(), 1, 1);

        // Calculate the first day of the previous year
        LocalDate firstDayOfPreviousYear = firstDayOfCurrentYear.minusYears(1);

        // Filter transactions for the previous year
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

    private void displaySearchByVendorReport() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter vendor name to search:");
        String vendorName = scnr.nextLine();

        // Retrieve and display transactions filtered by the vendor name
        List<Transaction> transactions = transactionManager.getAllTransactions();
        ArrayList<Transaction> vendorTransactions = new ArrayList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                vendorTransactions.add(transaction);
            }
        }
        ledger.displayLedger(vendorTransactions);
    }
}
