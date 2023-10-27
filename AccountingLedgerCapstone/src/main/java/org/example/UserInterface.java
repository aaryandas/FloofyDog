package org.example;

import java.util.Scanner;


public class UserInterface {
    private Ledger ledger = new Ledger();
    private TransactionManager transactionManager = new TransactionManager();
    private Report report = new Report();

    //ALL DISPLAY SCREENS BELOW
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
            System.out.println("6) Custom Search");
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
                case 6:
                    displayCustomSearch();
                    break;
                case 0:
                    isDisplayingReports = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    //ALL METHODS BELOW
    private void addDeposit(){
        transactionManager.addDeposit();
    }
    private void makePayment(){
        transactionManager.makePayment();
    }

    private void displayAllTransactions() {
        ledger.allTransactions();
    }

    private void displayDeposits(){
        ledger.deposits();
    }

    private void displayPayments(){
        ledger.payments();
    }

    private void displayMonthToDateReport(){
        report.monthToDateReport();
    }

    private void displayPreviousMonthReport(){
        report.previousMonthReport();
    }

    private void displayYearToDateReport(){
        report.yearToDateReport();
    }

    private void displayPreviousYearReport(){
        report.previousYearReport();
    }

    private void displaySearchByVendorReport(){
        report.searchByVendorReport();
    }

    private void displayCustomSearch(){
        report.customSearchReport();
    }


}
