package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.println("Enter your numerical score: ");
        int score = scnr.nextInt();

        if(score >= 90 && score <= 100){
            System.out.println("A.");
        } else if (score >= 80 && score <= 89) {
            System.out.println("B.");
        }
        else if(score >= 70 && score <= 79){
            System.out.println("C.");
        }
        else if(score >= 60 && score <= 69){
            System.out.println("D.");
        }
        else if(score < 60 && score >= 0){
            System.out.println("F.");
        }
        else{
            System.out.println("Please input a valid score.");
        }
        scnr.close();
    }
}