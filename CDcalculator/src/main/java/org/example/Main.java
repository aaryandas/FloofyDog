package org.example;

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        double deposit;
        double interestRate;
        double numYears;
        double futureValue;
        double totalInterest;
        double n = 365;

        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter the initial deposit: ");
        deposit = scnr.nextDouble();

        System.out.println("Enter the interest rate: ");
        interestRate = scnr.nextDouble();

        System.out.println("Enter the number of years from maturation: ");
        numYears = scnr.nextDouble();

        futureValue = totalAmount(deposit, interestRate, n , numYears);
        totalInterest = futureValue - deposit;

        System.out.printf("If you deposit $%.2f in a CD that ears %.2f%% interest and matures in %.2f years, your CD's ending balance will be $%.2f and you would have earned $%.2f in interest", deposit, interestRate, numYears, futureValue, totalInterest);

    }
    public static double totalAmount(double p, double r, double n, double t){
        double a =  (p * Math.pow((1 + ((r/100)/n)), (n * t)));
        return a;
    }
}