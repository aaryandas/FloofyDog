package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ledger {

    public void displayLedger(ArrayList<Transaction> transactions) {

        Comparator<Transaction> dateComparator = new Comparator<Transaction>(){
            @Override
            public int compare(Transaction t1, Transaction t2){
                LocalDate date1 = LocalDate.parse(t1.getDate());
                LocalDate date2 = LocalDate.parse(t2.getDate());

                return date1.compareTo(date2);
            }
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
}
