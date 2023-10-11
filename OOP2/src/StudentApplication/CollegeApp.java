package StudentApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;


public class CollegeApp extends Student {
    // Declare a static ArrayList of Student objects called "students"
    static ArrayList<Student> students = new ArrayList<>();
    // Declare the main method
    public static void main(String[] args) {
        // Create new MatureStudent and Full-timeStudent then add them to the "students" ArrayList
        students.add(new MatureStudent(101, "Jona Vegan", 23));
        students.add(new MatureStudent(102, "Alexandra Kimchi", 24));
        students.add(new MatureStudent(103, "Josh Slayer", 25));
        students.add(new FulltimeStudent(104, "Jona Vegan", "Jona@gmail.com"));
        students.add(new FulltimeStudent(105, "Alexandra Kimchi", "Alexandra@gmail.com"));
        students.add(new FulltimeStudent(106, "Jos Slayer", "yosh@gmail.com"));
        // Call the studentManagement method
        studentManagement();
    }

    public static void studentManagement(){
        System.out.println("Welcome to the College Student Application");
        // Start while loop
        while (true) {
            System.out.println("\nPlease select number of the options");
            System.out.println("1. View all students\n2. View Full-time students\n3. View mature students\n4. Add new full-time student\n5. Add new mature student\n6. Edit student details\n7. Remove student\n8. View all students alphabetically\n9. Print student list to a text file\n10. Exit");
            String option = input.next();
            // Start a switch statement based on the user's choice
            switch (option) {
                // Call the showAllStudents method
                case "1" -> showAllStudents();

                // Call the showFStudents method
                case "2" -> showFStudents();

                // Call the showMStudents method
                case "3" -> showMStudents();

                // Call the addFStudent method
                case "4" -> addFStudent();

                // Call the addMStudent method
                case "5" -> addMStudent();

                // Call the editStudent method
                case "6" -> editStudent();

                // Call the removeStudent method
                case "7" -> removeStudent();

                // Call the showStudentsAlphabetically method
                case "8" -> showStudentsAlphabetically();

                // Call the printStudent method
                case "9" -> printStudent();

                // Exit the program
                case "10" -> {
                    System.out.println("Goodbye!!!");
                    System.exit(0);
                }
                // If the user entered wrong information, print an invalid option message
                default -> System.out.println("Invalid option!!!");
            }// end option statement
        }//end while statement
    }//end student management method


    // This method prints out details of all students in the students list
    public static void showAllStudents() {
        // Iterate over each student in the students list
        for (Student student : students) {
            // Print out details of the current student
            System.out.println(student);
        }
    }// end show all students methods

    // This method prints out details of all full-time students in the students list
    public static void showFStudents() {
        // Iterate over each student in the students list
        for (Student student : students) {
            // Check if the current student is a full-time student
            if (student instanceof FulltimeStudent) {
                // Print out details of the current full-time student
                System.out.println(student);
            }
        }
    }

    // This method prints out details of all mature students in the students list
    public static void showMStudents() {
        // Iterate over each student in the students list
        for (Student student : students) {
            // Check if the current student is a mature student
            if (student instanceof MatureStudent) {
                // Print out details of the current mature student
                System.out.println(student);
            }
        }
    }


    public static void addFStudent() {
        System.out.print("Enter student ID: ");
        userID = input.next();
        limitNumber();// call limitNumber method to validate input is a positive integer
        int id = Integer.parseInt(userID);// convert input to integer
        for (Student student : students) {
            if (student.getStudentID() == id) {// check if student ID already exists
                System.out.println("Student ID already exists. Please enter a different ID.");
                return; // exit method if student ID already exists
            }
        }
        System.out.print("Enter student Name: ");
        userLetters = input.next();
        lettersInput();// call lettersInput method to validate input contains only letters
        String name = String.valueOf(userLetters);// convert input to string
        System.out.print("Enter student Email: ");
        String email = input.next();
        // validate email format using regular expression
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            System.out.println("Invalid email address. Please try again.");
            return; // exit method if email format is invalid
        }
        // add new Full-timeStudent object to students ArrayList
        students.add(new FulltimeStudent(id, name , email ));
        System.out.println("Full-time Student added!"); // display success message
    }


    public static void addMStudent() {
        System.out.print("Enter student ID: ");
        userID = input.next();
        // Validate that the input is a number
        limitNumber();
        int id = Integer.parseInt(userID);
        // Check if the student ID already exists in the system
        for (Student student : students) {
            if (student.getStudentID() == id) {
                System.out.println("Student ID already exists. Please try again.");
                return;
            }
        }
        System.out.print("Enter student name: ");
        userLetters = input.next();
        // Validate that the input contains only letters
        lettersInput();
        String name = String.valueOf(userLetters);
        System.out.print("Enter student Age: ");
        userID = input.next();
        // Validate that the input is a number
        limitNumber();
        int age = Integer.parseInt(userID);
        // Check if the student is eligible to be a mature student
        if (age >= 23 && age <= 60) {
            // Create a new MatureStudent object and add it to the students list
            students.add(new MatureStudent(id, name , age));
            System.out.println("Mature Student added!");
        } else {
            // If the student is not eligible to be a mature student, display an error message
            System.out.println("Student must be over 23 years old to be a mature student.");

        }
    }


    public static void editStudent() {
        //Enter student ID
        System.out.println("Enter student ID: ");
        userID = input.next();
        limitNumber();
        int id = Integer.parseInt(userID);
        // search for the student with the entered ID
        for (Student student : students) {
            if (student.getStudentID() == id) {
                // call the editStudentDetails method on the found student object
                student.editStudentDetails();
                return;
            }
        }
        // print message if student is not found
        System.out.println("Student not found.");
    }


    public static void removeStudent() {
        // prompt user to enter student ID
        System.out.print("Enter student ID: ");
        userID = input.next();
        limitNumber();
        int id = Integer.parseInt(userID);
        // search for the student with the entered ID
        for (Student student : students) {
            if (student.getStudentID() == id) {
                // remove the found student object from the students list
                students.remove(student);
                System.out.println("Student removed!");
                return;
            }
        }
        // print message if student is not found
        System.out.println("Student not found.");
    }


    public static void showStudentsAlphabetically() {
        // Sort the list of students based on their names
        students.sort(Comparator.comparing(Student::getStudentName)); // Lambda expression to define the comparison function
        // Print the sorted list of students
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void printStudent() {
        try {
            // Create a new FileWriter object to write to a file named "studentList.txt"
            FileWriter writer = new FileWriter("studentList.txt");
            // Write a header to the file
            writer.write("College Students table\n");
            // Loop over the list of students and write each student's information to the file
            for (Student student : students) {
                writer.write(student.toString() + "\n");
            }
            // Close the writer to ensure that all data is written to the file
            writer.close();
            // Print a message indicating that the file was successfully written
            System.out.println("Student list printed to file!");
        } catch (IOException e) {
            // If an error occurs while writing to the file, print an error message
            System.out.println("Error coding to file.");
        }
    }// end printStudent method
}// end college app classes
