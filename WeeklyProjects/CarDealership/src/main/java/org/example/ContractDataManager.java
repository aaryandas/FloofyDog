package org.example;

//still in progress

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ContractDataManager {

    private static List<Contract> contracts = new ArrayList<>();
    private static final String CONTRACTS_TXT = "src/main/resources/contracts.txt";

    private ContractDataManager() {

    }

    public static List<Contract> getContract() {
        return contracts;
    }

    public static void saveContract(Contract contract) {
        contracts.add(contract);
        writeContractsToFile();
    }

    private static void readContractsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CONTRACTS_TXT))) {
            contracts = (List<Contract>) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Error");
        }
    }

    private static void writeContractsToFile(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CONTRACTS_TXT))){
            oos.writeObject(contracts);
        }
        catch (IOException ex){
            System.out.println("Error");
        }
    }

}