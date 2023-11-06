package org.example;
import java.util.Scanner;

public class Main {
    static int matchGoals[] = {2, 3, 1, 4, 2, 0, 2, 1, 3, 2}; //initialize array

    public static void main(String[] args) {

        int totalGoals = totalGoals(); //call method for sum of goals and store in totalGoals

        double averageGoals = (double) totalGoals / matchGoals.length; //divide total number of goals by the number of matches and store average as a double

        System.out.println("The total number of goals scored is " + totalGoals); //print total number of goals scored
        System.out.println("The average number of goals scored is " + averageGoals); //print average number of goals scored
    }
    public static int totalGoals(){ //method for calculating sum
        int sum = 0;

        for (int matchGoal : matchGoals) { //iterate through each element in the array and add it to sum
            sum += matchGoal;
        }
        return sum; //return statement
    }
}