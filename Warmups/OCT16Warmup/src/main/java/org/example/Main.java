package org.example;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayList = {
                5, 7, 2, 3, 1
        };

        Arrays.sort(arrayList);
        for(int number : arrayList){
            System.out.println(number);
        }
    }
}