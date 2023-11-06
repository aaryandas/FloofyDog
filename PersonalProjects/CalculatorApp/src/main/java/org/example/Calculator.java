package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{

    JFrame frame;

    //holds all the numbers typed in, as well as the result
    JTextField textField;

    //numbers 0 through 9
    JButton[] numberButtons = new JButton[10];

    //operation buttons, like add, subtract, multiply, divide, decimal, equals sign, delete, and clear
    JButton[] functionButtons = new JButton[8];

    JButton addButton, subButton, mulButton, divButton;

    JButton decButton, equButton, delButton, clrButton;

    JPanel panel;

    Font myFont = new Font("Monospaced", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator(){

        //Methods related to the frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //allows us to close out of the program
        frame.setSize(420, 550);
        frame.setLayout(null);

        //adds a text field that can take string input
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false); //makes it so textbox can't be freely edited

        //these are all the function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        decButton = new JButton(".");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");


        frame.add(textField);
        frame.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
