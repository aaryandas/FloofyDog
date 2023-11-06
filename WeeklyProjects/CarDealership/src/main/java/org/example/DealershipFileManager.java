package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DealershipFileManager {
    private DealershipFileManager(){

    }

    public static Dealership getDealership() {

        Dealership dealership = new Dealership("Car Dealership", "1234 Cars Avenue", "123-4567");

        try {
            //Make a file input stream that points to the file that holds my vehicles
            FileInputStream fis = new FileInputStream("src/main/resources/vehicles.csv");

            //Make a scanner to take in the file input stream
            Scanner scnr = new Scanner(fis);

            //Create Dealership object
            scnr.nextLine();

            //Loop through the file until there is no more file
            String userInput;
            while (scnr.hasNextLine()) {
                userInput = scnr.nextLine();
                //Take each row, and use the String.split() method to get your data
                String[] line = userInput.split("\\|");

                //Create a vehicle, from the array, that String.split() returns
                Vehicle vehicle = new Vehicle(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2], line[3], line[5], line[4], Integer.parseInt(line[6]), Double.parseDouble(line[7]));

                //Take that vehicle and add it to the inventoryList of the Dealership
                dealership.addVehicle(vehicle);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Could not find file to read from");
        }

        return dealership;
    }

    public static void saveDealership(Dealership dealership){
        try{
            FileWriter fileWrite = new FileWriter("src/main/resources/vehicles.csv");

            String headerRow = String.format("%s|%s|%s %n", dealership.getName(), dealership.getAddress(), dealership.getPhone());
            fileWrite.write(headerRow);

            for(Vehicle vehicle : dealership.getAllVehicles()){
                String line = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f %n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getColor(), vehicle.getVehicleType(), vehicle.getOdometer(), vehicle.getPrice());

                fileWrite.write(line);
            }
            fileWrite.close();
        }
        catch(IOException ex){
            System.out.println("Could not write to file");
        }
    }
}
