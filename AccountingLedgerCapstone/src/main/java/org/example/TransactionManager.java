package org.example;

import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//I like that you created a class to handle anything dealing with reading and writing to a file
//This is called separation of concerns
public class TransactionManager {
    public ArrayList<Transaction> transactions = new ArrayList<>();

    public void AddDeposit(Transaction deposit){
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);

            //You might want to add an escape character like %n
            String transactionLine = String.format("%s|%s|%s|%f", deposit.getDate(), deposit.getTime(), deposit.getVendor(), deposit.getAmount() );

            fileWriter.write(transactionLine);
            fileWriter.close();

        } catch (IOException ex) {
            System.out.println("Sorry, couldn't add that transaction to the ledger");
        }
    }

    public void MakePayment(Transaction payment) {
        try {
            FileWriter fileWriter = new FileWriter("src/main/resources/transactions.csv", true);
            //Ditto
            String transactionLine = String.format("%s|%s|%s|-%f", payment.getDate(), payment.getTime(), payment.getVendor(), payment.getAmount());

            fileWriter.write(transactionLine);
            fileWriter.close();

        } catch (IOException ex) {
            System.out.println("Sorry, couldn't add that transaction to the ledger");
        }
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

                Transaction transaction = new Transaction(rowArray[0], rowArray[1], rowArray[2], Double.parseDouble(rowArray[3]));

                transactions.add(transaction);
            }

        }
        catch(FileNotFoundException ex){
            System.out.println("Transaction file was not found");
        }

        return transactions;
    }


}
