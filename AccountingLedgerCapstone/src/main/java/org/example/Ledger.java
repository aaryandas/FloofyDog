package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ledger {
    private TransactionManager transactionManager = new TransactionManager();

    public void displayLedger(ArrayList<Transaction> transactions) {

        Comparator<Transaction> dateComparator = (t1, t2) -> {
            LocalDate date1 = LocalDate.parse(t1.getDate());
            LocalDate date2 = LocalDate.parse(t2.getDate());

            return date1.compareTo(date2);
        };
        Collections.sort(transactions, dateComparator);

        if(transactions.isEmpty()){
            System.out.println("No transactions to display");
        }
        else{
            System.out.println("**********TRANSACTION LEDGER**********");
            for(Transaction transaction : transactions){
                System.out.println(transaction);
            }
        }
    }

    public void allTransactions() {
        // Read and display all transactions from transactions.txt
        ArrayList<Transaction> allTransactions = new ArrayList<>(transactionManager.getAllTransactions());
        displayLedger(allTransactions);
    }

    public void deposits() {
        // Read and display deposit transactions from transactions.txt
        ArrayList<Transaction> deposits = new ArrayList<>(transactionManager.getDeposits());
        displayLedger(deposits);
    }

    public void payments() {
        // Read and display payment transactions from transactions.txt
        ArrayList<Transaction> payments = new ArrayList<>(transactionManager.getPayments());
        displayLedger(payments);
    }

}
