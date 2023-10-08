package org.example;

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {

        //declare variables
        double principal;
        double annualInterestRate;
        double loanLengthYears;
        double loanLengthMonths;
        double totalInterest;

        //initialize scanner
        Scanner scnr = new Scanner(System.in);

        //prompt user input
        System.out.println("What is the principal amount?");
        principal = scnr.nextDouble();

        System.out.println("What is the annual interest rate?");
        annualInterestRate = scnr.nextDouble();
        double monthlyInterestRate = annualInterestRate/12;

        System.out.println("What is the loan length? (in years)");
        loanLengthYears = scnr.nextDouble();
        loanLengthMonths = loanLengthYears * 12;

        //calculations
        double monthlyPayment = monthlyPayment(principal, monthlyInterestRate, loanLengthMonths);
        totalInterest = (monthlyPayment * loanLengthMonths) - principal;

        //output
        System.out.printf("A $%f loan at %.3f interest for %f years would have a $%.2f/mo payment with a total interest payment of $%.2f.", principal, annualInterestRate, loanLengthYears, monthlyPayment, totalInterest );

    }
    //method for calculating monthly payments
    public static double monthlyPayment(double p, double r, double l){
        double numerator = p * (r/100) * Math.pow(((r/100)+1),l);
        double denominator = Math.pow(((r/100) + 1), l) - 1;
        return numerator/denominator;
    }
}