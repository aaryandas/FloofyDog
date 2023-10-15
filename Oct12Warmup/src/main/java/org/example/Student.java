package org.example;

public class Student {
    private String firstName;
    private String lastName;
    private String studentID;
    private int yearInCollege;
    private boolean internationalStudent;
    private int streetNumber;
    private String streetName;

    public Student(String firstName, String lastName, String studentID, int yearInCollege, boolean internationalStudent, int streetNumber, String streetName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.yearInCollege = yearInCollege;
        this.internationalStudent = internationalStudent;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
    }

    public Student(String firstName, String lastName, String studentID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public int getYearInCollege() {
        return yearInCollege;
    }

    public void setYearInCollege(int yearInCollege) {
        this.yearInCollege = yearInCollege;
    }

    public boolean isInternationalStudent() {
        return internationalStudent;
    }

    public void setInternationalStudent(boolean internationalStudent) {
        this.internationalStudent = internationalStudent;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void greeting(){
        System.out.println("Hi my name is " + this.firstName + " " + this.lastName + "!");
    }


}
