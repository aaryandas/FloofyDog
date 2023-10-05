package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //declaring variables
        String pickupDate;
        int numDays = 0;

        String tolltagRental;
        String gpsrental;
        String roadAssist;
        String userResponse;

        int age = 0;
        final double basicRental = 29.99;
        final double underageSurcharge = 29.99 * 0.3;
        double surcharge = 0;
        double optionsCost = 0;
        double totalCost = 0;


        //initialize scanner
        Scanner scnr = new Scanner(System.in);

        //prompt user for pickup date
        System.out.println("When would you like to pick the rental car up?");
        pickupDate = scnr.nextLine();

        System.out.println("What is your age?");
        age = scnr.nextInt();

        //prompt user for rental duration in days
        System.out.println("How many days would you like to keep the rental for? (enter as a number)");
        numDays = scnr.nextInt();
        scnr.nextLine();

        //prompt user for toll tag choice
        System.out.println("Would you like an electronic toll tag at $3.95 a day?");
        userResponse = scnr.nextLine();
        //update optionsCost based on userResponse
        if (userResponse.equalsIgnoreCase("yes")) {
            System.out.println("Sounds good! This rental will include an electronic toll tag");
            optionsCost = numDays * 3.95;
            }
        else if(userResponse.equalsIgnoreCase("no")) {
            System.out.println("This rental will not include an electronic toll tag");
            }
        else {
            System.out.println("Please enter 'yes' or 'no' as a response");
            }

        //prompt user for GPS choice
        System.out.println("Would you like to rent a GPS at $2.95 a day?");
        userResponse = scnr.nextLine();
        //update optionsCost based on userResponse
        switch (userResponse){
            case "yes":
                System.out.println("Sounds good! This rental will include a GPS rental");
                optionsCost = optionsCost + (numDays * 2.95);
                break;
            case "no":
                System.out.println("This rental will not include a GPS rental");
                break;
            default:
                System.out.println("Please enter 'yes' or 'no' as a response");
                break;
        }

        //prompt user for roadside assistance choice
        System.out.println("Would you like roadside assistance at $3.95 a day?");
        userResponse = scnr.nextLine();
        //update optionsCost based on userResponse
        switch (userResponse){
            case "yes":
                System.out.println("Sounds good! This rental will include Roadside Assistance");
                optionsCost = optionsCost + (numDays + 2.95);
                break;
            case "no":
                System.out.println("This rental will not include Roadside Assistance");
                break;
            default:
                System.out.println("Please enter 'yes' or 'no' as a response");
                break;
        }

        //calculations
        if(age >= 25) {
            totalCost = basicRental + optionsCost + underageSurcharge;
            surcharge = underageSurcharge;
        }
        else {
            totalCost = basicRental + optionsCost;
            surcharge = 0;
        }

        //output to user
        System.out.printf("Here is the cost breakdown for your order: \n    Basic Car Rental Cost: $%.2f\n    Cost of Additional Options: $%.2f\n    Underage driver surcharge: $%.2f\n    Total Cost: $%.2f\n", basicRental, optionsCost, surcharge, totalCost);
        System.out.printf("Your rental will be available on %s. Thank you and enjoy!", pickupDate);
    }
}