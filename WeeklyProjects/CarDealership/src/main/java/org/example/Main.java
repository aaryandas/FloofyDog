package org.example;

//Overall a solid job, you get separation of concerns
//Each class sticks to its responsibility without overlap
//No need for in depth comments, it's good work.
public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();

        ui.display();

    }
}