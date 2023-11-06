package org.example;

import java.util.ArrayList;

public class Library {

    //Represents a collection of all the books, contains functionality to add/find books
    //Calls the LibraryFileManager class to read/write data
    private ArrayList<Book> books = new ArrayList<>();
    private String libraryName;

    public Library(String libraryName) {
        this.libraryName = libraryName;
    }


    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public void addBook(){
        //Calls saveLibraryData to write to the file
        //Use books.add() to add a book to the ArrayList
    }

    public Book findBookByISBN(String ISBN){
        //Calls loadLibraryData to read from the file
        //Uses a for loop to iterate through the ArrayList and find books
    }

    public void listAvailableBooks(){
        //Calls loadLibraryData to read from the file
        //Uses a for loop to iterate through the ArrayList and list books

    }


}
