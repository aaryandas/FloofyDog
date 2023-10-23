package org.example;
import java.util.Scanner;


public class Main {
    static Scanner scnr = new Scanner(System.in);
    static int command = 0;

    public static void main(String[] args) {

        //initialize book array and populate
        Book[] books = initializeBooks();

        while (true) {

            System.out.println("What brings you to the library today?");
            System.out.println("   1 - Show Available Books");
            System.out.println("   2 - Show Checked Out Books");
            System.out.println("   3 - Exit");
            System.out.println("Please enter the number corresponding to the option you want to pick");
            command = scnr.nextInt();

            switch (command) {
                case 1:
                    showAvailableBooks(books);
                    break;
                case 2:
                    showCheckedOutBooks(books);
                    break;
                case 3:
                    System.out.println("Exiting program");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }
    }

    public static void showAvailableBooks(Book[] books) {

        boolean booksAvailable = false;

        for (Book book : books) {
            if (!book.isCheckedOut()) {

                System.out.printf("Book ID: %d\n", book.getId());
                System.out.printf("Book ISBN: %s\n", book.getIsbn());
                System.out.printf("Book Title: %s\n", book.getTitle());
                System.out.println();
                booksAvailable = true;
            }
        }
        if(!booksAvailable) {
            System.out.println("All books are currently checked out. Please try again later!");
        }

        System.out.println("Choose one of the following options:");
        System.out.println("   1 - Check out a book");
        System.out.println("   2 - Go back to the home screen");
        System.out.println("Please enter the number corresponding to the option you want to pick");
        command = scnr.nextInt();
        scnr.nextLine();

        switch (command) {
            case 1:
                System.out.println("Please enter the ID of the book you want");
                int id = scnr.nextInt();
                scnr.nextLine();
                boolean bookFound = false;

                for (Book book : books) {
                    if (book.getId() == id && !book.isCheckedOut()){
                    System.out.println("Please enter your name: ");
                    String name = scnr.nextLine();
                    book.checkOut(name);
                    book.setCheckedOutTo(name);
                    System.out.printf("Enjoy your book, %s!\n", name);
                    bookFound = true;
                    break;
                }
        }
            if(!bookFound){
                System.out.println("Invalid book ID or the book is already checked out");
            }

            case 2:
                break;

            default:
                System.out.println("Invalid choice. Please try again");
        }
    }


        public static void showCheckedOutBooks(Book[] books){
            boolean checkedOutBooks = false;


            for (Book book : books) {
                if (book.isCheckedOut()) {
                    checkedOutBooks = true;


                    System.out.printf("Book ID: %d\n", book.getId());
                    System.out.printf("Book ISBN %s\n", book.getIsbn());
                    System.out.printf("Book Title %s\n", book.getTitle());
                    System.out.printf("Checked out to %s\n", book.getCheckedOutTo());
                    System.out.println();
                }
            }

            if(!checkedOutBooks) {
                System.out.println("No books are currently checked out!");
            }

                    System.out.println("Choose one of the following options:");
                    System.out.println("   1 - Check in a book");
                    System.out.println("   2 - Go back to the home screen");
                    System.out.println("Please enter the letter corresponding to the option you want to pick");
                    command = scnr.nextInt();
                    scnr.nextLine();

                    switch(command){
                        case 1:
                            System.out.println("Please enter the ID of the book you want to check in: ");
                            int id = scnr.nextInt();

                            for(Book checkingIn : books){
                                if(checkingIn.getId() == id){
                                    checkingIn.checkIn();
                                    System.out.println("The book was checked in!");
                                    break;
                                }
                            }
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again");

                    }
                }

        private static Book[] initializeBooks() {
            Book[] books = new Book[20];

            books[0] = new Book(1, "0446310786", "To Kill a Mockingbird", false, "");
            books[1] = new Book(2, "9780451524935", "1984", false, "");
            books[2] = new Book(3, "9780141439518", "Pride and Prejudice", false, "");
            books[3] = new Book(4, "979-8351145013", "The Great Gatsby", false, "");
            books[4] = new Book(5, "978-0316769174", "Catcher in the Rye", false, "");
            books[5] = new Book(6, "978-1853260087", "Moby-Dick", false, "");
            books[6] = new Book(7, "978-0618640157", "The Lord of the Rings", false, "");
            books[7] = new Book(8, "978-1400079988", "War and Peace", false, "");
            books[8] = new Book(9, "978-0140268867", "The Odyssey", false, "");
            books[9] = new Book(10, "978-0486275437", "Alice's Adventures in Wonderland", false, "");
            books[10] = new Book(11, "979-8824523010", "The Adventures of Sherlock Holmes", false, "");
            books[11] = new Book(12, "978-0618260300", "The Hobbit", false, "");
            books[12] = new Book(13, "978-0060850524", "Brave New World", false, "");
            books[13] = new Book(14, "978-0143131847", "Frankenstein", false, "");
            books[14] = new Book(15, "978-0593466346", "The Sun Also Rises", false, "");
            books[15] = new Book(16, "978-0142437230", "Don Quixote", false, "");
            books[16] = new Book(17, "978-1451635621", "Gone with the Wind", false, "");
            books[17] = new Book(18, "0060883286", "One Hundred Years of Solitude", false, "");
            books[18] = new Book(19, "978-0307387899", "The Road", false, "");
            books[19] = new Book(20, "978-0439023528", "The Hunger Games", false, "");

            return books;

        }
    }


