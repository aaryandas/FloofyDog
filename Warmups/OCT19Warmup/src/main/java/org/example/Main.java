package org.example;

import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {

        for(int i = 1; i < 6; i++){
            numbers.add(i);
        }

        for(int number : numbers){
            System.out.println(number);
        }

        int sum = sum();
        double average = (double) sum / numbers.size();

        System.out.printf("The sum of all the integers is: %d\n", sum);
        System.out.printf("The average of all the integers is: %.2f", average);
    }
    public static int sum(){
        int sum = 0;

        for(int number : numbers){
            sum += number;
        }
        return sum;
    }
}