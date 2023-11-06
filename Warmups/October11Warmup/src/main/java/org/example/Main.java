package org.example;

public class Main {
    public static void main(String[] args) {

    /* for(int i = 1; i <= 20; i++){
            if(i % 2 == 0){
                System.out.println(i);
            }
        }

        int number = 1;
        while(number <= 20){
            if(number % 2 == 1){
                System.out.println(number);
                number++;
            }
            else{
                number++;
            }
        }
*/
        //challenge question
        //counter keeps track of when we hit the 3 numbers
        int counter = 0;

        for(int i = 1; i <= 600; i++){
            //if loop to check whether i is divisible by 7 and 9
            if((i % 7 == 0)&&(i % 9 == 0)){
                System.out.println(i);
                counter++;
            }
            //if loop to stop the for loop once we hit 3 numbers
            if(counter == 3){
                break;
            }
        }
    }
}