package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        while(true){
            try {
                System.out.println("Please enter a numerator: ");
                int numerator = scnr.nextInt();

                System.out.println("Please enter a denominator: ");
                int denominator = scnr.nextInt();

                int answer = division(numerator, denominator);

                System.out.printf("The answer is %d", answer);
                System.exit(0);

            } catch(ArithmeticException e){
                System.out.println("You can't divide by zero!");
            }
        }
    }
    public static int division(int numerator, int denominator){
        return  (numerator / denominator);
    }
}