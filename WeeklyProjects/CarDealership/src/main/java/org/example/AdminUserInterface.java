package org.example;

import java.util.List;
import java.util.Scanner;

public class AdminUserInterface {

    private static final String ADMIN_PASSWORD = "password";

    public static void display(){
        Scanner scnr = new Scanner(System.in);
        String password = scnr.nextLine();

        if(!password.equals(ADMIN_PASSWORD)){
            System.out.println("Incorrect password. Exiting program");
        }

        System.out.println("**********ADMIN SCREEN**********");
        System.out.println("1. List all contracts");
        System.out.println("2. List last 10 contracts");
        System.out.println("Please enter the number correspoding to your choice: ");

        int choice = scnr.nextInt();
        switch (choice){
            case 1:
                listAllContracts();
                break;
            case 2:
                listLast10Contracts();
                break;
            default:
                System.out.println("Invalid choice, please try again");
        }
    }

    private static void listAllContracts(){
        List<Contract> contracts = ContractDataManager.getContract();
        for(Contract contract : contracts){
            System.out.println(contract);
        }
    }

    private static void listLast10Contracts(){
        List<Contract> contracts = ContractDataManager.getContract();
        int index = Math.max(0, contracts.size() - 10);

        for(int i = index; i < contracts.size(); i++){
            System.out.println(contracts.get(i));
        }
    }
}
