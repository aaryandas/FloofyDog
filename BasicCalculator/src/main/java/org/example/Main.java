package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        //declare variables
        double firstNumber;
        double secondNumber;

        //declare scanner
        Scanner potato = new Scanner(System.in);

        //request user input for 2 numbers
        System.out.print("Enter the first number: ");
        firstNumber = potato.nextDouble();

        System.out.print("Enter the second number: ");
        secondNumber = potato.nextDouble();
        potato.nextLine();

        //present user with possible calculations
        System.out.printf("\nPossible calculations: \n   (A)dd\n   (S)ubtract\n   (M)ultiply\n   (D)ivide\nPlease select an option(A, S, M, or D): ");
        String option = potato.nextLine();

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
        else{
            System.out.println("That is not a valid operation!");
        }
    }

    //calculation methods
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