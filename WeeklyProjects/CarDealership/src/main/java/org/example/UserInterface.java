package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(){
     dealership = DealershipFileManager.getDealership();
    }

    public void display(){
        Scanner scnr = new Scanner(System.in);
        boolean isDisplaying = true;

        while(isDisplaying){
            System.out.printf("Welcome to %s!\n", dealership.getName());
            System.out.printf("Located at %s\n", dealership.getAddress());
            System.out.println("Please choose one of the following options: ");
            System.out.println("1. Find vehicles within a price range");
            System.out.println("2. Find vehicles by make/model");
            System.out.println("3. Find vehicles by year range");
            System.out.println("4. Find vehicles by color");
            System.out.println("5. Find vehicles by mileage range");
            System.out.println("6. Find vehicles by type (car, truck, SUV, van)");
            System.out.println("7. List ALL vehicles");
            System.out.println("8. Add a vehicle");
            System.out.println("9. Remove a vehicle");
            System.out.println("0. Exit dealership");

            try {
                int userInput = scnr.nextInt();

                switch(userInput){
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processGetAllVehiclesRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        DealershipFileManager.saveDealership(dealership);
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        DealershipFileManager.saveDealership(dealership);
                        break;
                    case 0:
                        DealershipFileManager.saveDealership(dealership);
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option, please try again");
                        break;
                }
            }
            catch(InputMismatchException ex){
                System.out.println("Please select a number");
                scnr.nextLine();
            }
        }
        scnr.close();
    }

    public void processGetByPriceRequest(){
        boolean isRunning = true;

        while(isRunning){
            try {
                Scanner scnr = new Scanner(System.in);

                System.out.println("Please enter the minimum price of your vehicle budget: ");
                double minPrice = scnr.nextDouble();

                System.out.println("Please enter the maximum price of your vehicle budget: ");
                double maxPrice = scnr.nextDouble();

                if (minPrice < maxPrice) {
                    System.out.printf("List of all vehicles between %d and %d", minPrice, maxPrice);
                    List<Vehicle> vehicleList = dealership.getVehiclesByPrice(minPrice, maxPrice);
                    displayVehicles(vehicleList);
                    isRunning = false;
                } else {
                    System.out.println("Minimum price cannot be greater than maximum price");
                }
            }
            catch(InputMismatchException ex){
                System.out.println("Invalid input for price, please try again");
            }
        }
    }

    public void processGetByMakeModelRequest(){
        boolean isRunning = true;

        while(isRunning) {
            try {
                Scanner scnr = new Scanner(System.in);

                System.out.println("Please enter the make of your desired vehicle: ");
                String make = scnr.nextLine();

                System.out.println("Please enter the model of your desired vehicle: ");
                String model = scnr.nextLine();

                List<Vehicle> vehicleList = dealership.getVehiclesByMakeModel(make, model);
                displayVehicles(vehicleList);
                isRunning = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input, please try again");
            }
        }
    }

    public void processGetByYearRequest(){
        boolean isRunning = true;

        while(isRunning) {
            try {
                Scanner scnr = new Scanner(System.in);

                System.out.println("Please enter the minimum year of your desired vehicle: ");
                int minYear = scnr.nextInt();

                System.out.println("Please enter the maximum year of your desired vehicle: ");
                int maxYear = scnr.nextInt();

                if (minYear <= maxYear) {
                    List<Vehicle> vehicleList = dealership.getVehiclesByYear(minYear, maxYear);
                    displayVehicles(vehicleList);
                    isRunning = false;
                } else {
                    System.out.println("Minimum year cannot be greater than maximum year");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input for year, please try again");
            }
        }
    }

    public void processGetByColorRequest(){
        boolean isRunning = true;

        while(isRunning){
            try {
                Scanner scnr = new Scanner(System.in);

                System.out.println("Please enter the color of your desired vehicle: ");
                String color = scnr.nextLine();

                List<Vehicle> vehicleList = dealership.getVehiclesByColor(color);
                displayVehicles(vehicleList);
                isRunning = false;
            }
            catch(InputMismatchException ex){
                System.out.println("Invalid input for color, please try again");
            }
        }
    }

    public void processGetByMileageRequest(){
        boolean isRunning = true;

        while(isRunning){
            try{
                Scanner scnr = new Scanner(System.in);

                System.out.println("Please enter the minimum mileage of your desired vehicle: ");
                int minMileage = scnr.nextInt();

                System.out.println("Please enter the maximum mileage of your desired vehicle: ");
                int maxMileage = scnr.nextInt();

                if(minMileage <= maxMileage){
                    List<Vehicle> vehicleList = dealership.getVehiclesByMileage(minMileage, maxMileage);
                    displayVehicles(vehicleList);
                    isRunning = false;
                }
                else{
                    System.out.println("Minimum mileage cannot be greater than maximum mileage");
                }
            }
            catch(InputMismatchException ex){
                System.out.println("Mileage must be a number");
            }
        }
    }

    public void processGetByVehicleTypeRequest(){
        boolean isRunning = true;

        while(isRunning){
            try{
                Scanner scnr = new Scanner(System.in);

                System.out.println("Please enter your desired vehicle type: ");
                String vehicleType = scnr.nextLine();

                List<Vehicle> vehicleList = dealership.getVehiclesByType(vehicleType);
                displayVehicles(vehicleList);
                isRunning = false;
            }
            catch(InputMismatchException ex){
                System.out.println("Invalid input for vehicle type, please try again");
            }
        }
    }

    public void processGetAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {
        boolean isRunning = true;

        while (isRunning) {
            try {
                Scanner scnr = new Scanner(System.in);

                System.out.println("Please enter VIN: ");
                int vin = scnr.nextInt();
                scnr.nextLine();

                System.out.println("Enter year: ");
                int year = scnr.nextInt();
                scnr.nextLine();

                System.out.println("Enter make: ");
                String make = scnr.nextLine();

                System.out.println("Enter model: ");
                String model = scnr.nextLine();

                System.out.println("Enter color: ");
                String color = scnr.nextLine();

                System.out.println("Enter vehicle type: ");
                String vehicleType = scnr.nextLine();

                System.out.println("Enter odometer reading: ");
                int odometerReading = scnr.nextInt();
                scnr.nextLine();

                System.out.println("Enter price: ");
                double price = scnr.nextDouble();

                Vehicle vehicle = new Vehicle(vin, year, make, model, color, vehicleType, odometerReading, price);

                dealership.addVehicle(vehicle);

                System.out.println("Vehicle added successfully");

                isRunning = false;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input, please try again");
            }
        }
    }

    public void processRemoveVehicleRequest(){
        boolean isRunning = true;

        while(isRunning){
            try{
                Scanner scnr = new Scanner(System.in);

                System.out.println("Please enter the VIN of the vehicle you are removing: ");
                int vinToRemove = scnr.nextInt();
                scnr.nextLine();

                List<Vehicle> vehicleList = dealership.getAllVehicles();
                Vehicle vehicleToRemove = null;

                for(Vehicle vehicle : vehicleList){
                    if(vehicle.getVin() == vinToRemove){
                        vehicleToRemove = vehicle;
                        break;
                    }
                }

                if(vehicleToRemove != null){
                    dealership.removeVehicle(vehicleToRemove);
                    System.out.println("Vehicle removed successfully");
                }
                else{
                    System.out.printf("Vehicle with VIN %d not found in inventory", vinToRemove);
                }

                isRunning = false;
            }
            catch(InputMismatchException ex){
                System.out.println("Invalid input for VIN, please try again");
            }
        }
    }

    private void displayVehicles(List<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.toString());
        }
    }
}
