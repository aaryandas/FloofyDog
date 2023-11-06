package org.example;

import java.util.ArrayList;

public class LibraryMember {

    //Represents a member of the library, has their name and library card number
    //Has methods to check out and return books
    //Calls methods from the Library class to make checkOutBook and returnBook work

    private String name;
    private String libraryCardNumber;
    private ArrayList<Book> checkedOutBooks = new ArrayList<>();

    public void checkOutBook(Book book){
        //Have a while loop with a try and catch and a boolean to break the loop
        //Use a for loop to iterate through the ArrayList and select the book to be checked out
        //Use an if statement to confirm whether the book is already checked out
        //Use checkOut() from the Book class to add a book to the checkedOutBooks ArrayList
    }

    public void returnBook(Book book){
        //Have a while loop with a try and catch and a boolean to break the loop
        //Use a for loop to iterate through the ArrayList and check if the book is already checked out or not
        //Use an if statement to confirm whether the book is already checked out
        //Use returnBook() from the Book class to remove a book from the checkedOutBooks ArrayList

    }



}
