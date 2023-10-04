package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        double firstNumber;
        double secondNumber;

        Scanner scnr = new Scanner(System.in);

        //request user input for 2 numbers
        System.out.print("Enter the first number: ");
        firstNumber = scnr.nextDouble();

        System.out.print("Enter the second number: ");
        secondNumber = scnr.nextDouble();
        scnr.nextLine();

        //present user with possible calculations
        System.out.printf("\nPossible calculations: \n   (A)dd\n   (S)ubtract\n   (M)ultiply\n   (D)ivide\nPlease select an option: ");
        String option = scnr.nextLine();

        //insert calculation
        if(option.equalsIgnoreCase("A")){
            add(firstNumber, secondNumber);
        }
        else if(option.equalsIgnoreCase("S")){
            subtract(firstNumber, secondNumber);
        }
        else if(option.equalsIgnoreCase("M")){
            multiply(firstNumber, secondNumber);
        }
        else if(option.equalsIgnoreCase("D")){
            divide(firstNumber, secondNumber);
        }

    }
    public static void add(double num1, double num2){
        double answer = num1 + num2;
        System.out.printf("%.2f + %.2f = %.2f", num1, num2, answer);
    }

    public static void subtract(double num1, double num2){
        double answer = num1 - num2;
        System.out.printf("%.2f - %.2f = %.2f", num1, num2, answer);

    }

    public static void multiply(double num1, double num2){
        double answer = num1 * num2;
        System.out.printf("%.2f * %.2f = %.2f", num1, num2, answer);
    }

    public static void divide(double num1, double num2){
        double answer = num1 / num2;
        System.out.printf("%.2f / %.2f = %.2f", num1, num2, answer);
    }

}