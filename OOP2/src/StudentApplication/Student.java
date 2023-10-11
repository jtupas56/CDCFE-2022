package StudentApplication;

import java.util.Scanner;

public class Student {
    static Scanner input = new Scanner(System.in);
    private int studentID; // Private integer variable for the student's ID
    private String studentName; // Private String variable for the student's name
    public static String userLetters; // Public static String variable for the userLetters
    public static String userID; // Public static String variable for the userID
    public Student(int studentID, String studentName) { // Constructor of the student's ID and name
        this.studentID = studentID; // Assign the value to the studentID
        this.studentName = studentName; // Assign the value to the studentName
    }//constructor

    public Student () {} // Empty constructor

    public int getStudentID() { // Get the value of the ID variable
        return studentID;
    }

    public String getStudentName() { // Get the value of the Name variable
        return studentName;
    }

    public void setStudentName(String studentName) { // Set the value of the Name variable
        this.studentName = studentName;
    }

    @Override
    public String toString() { // Return ID and Name
        return "ID:" + studentID + ", Student Name: " + studentName;
    }

    public void editStudentDetails() {}

    public static void limitNumber() {
        while(!userID.matches("\\d{1,4}")){ // check the input that enters only digits and no more than 4 digits
            System.out.println("Only 4 digits maximum to enter, please try again! ");
            userID = input.next(); // read the user input
        }//end while
    }

    public static void lettersInput() {
        while(!userLetters.matches("[a-zA-Z]{1,15}")){ // check that the input contains only letters and is no more than 15 letters
            System.out.println("Only letters to enter, please try again! ");
            userLetters = input.next(); // read the user input
        }//end while
    }
}
