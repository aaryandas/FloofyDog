package org.example;

public class Main {
    public static void main(String[] args) {

        Student student = new Student("Mario", 25, 100.0);


        String name = student.getName();
        int age = student.getAge();
        double grade = student.getGrade();

        System.out.println("The student's name is : " + name);
        System.out.println("The student's age is : " + age);
        System.out.println("The student's grade is : " + grade);

        System.out.println("The student is passing T/F : " + student.isPassing());
    }
}