package org.example;

import javax.xml.transform.TransformerConfigurationException;
import java.util.ArrayList;
import java.util.Scanner;


public class Ledger {
    private ArrayList<Transaction> transactions;

    public Ledger(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void displayLedger(){
        for(Transaction transaction : transactions){
            System.out.println(transaction);
        }
    }

    public void displayAll(){
        for(Transaction transaction : transactions){
            System.out.println(transaction);
        }
    }

    public void displayDeposits(){
        for(Transaction transaction : transactions){
            if(transaction.getAmount() > 0){
                System.out.println(transaction);
            }
        }
    }

    public void displayPayments(){
        for(Transaction transaction : transactions){
            if(transaction.getAmount() < 0){
                System.out.println(transaction);
            }
        }
    }

    public void displayReports(String customSearch){
        System.out.println("Custom Search Results: ");
        for(int i = transactions.size() - 1; i >= 0; i--){
            Transaction transaction = transactions.get(i);
            if(transaction.getDescription().toLowerCase().contains(customSearch.toLowerCase())){
                System.out.println(transaction);
            }
        }
    }


}


